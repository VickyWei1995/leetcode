# 739 Daily Temperatures

https://leetcode.com/problems/daily-temperatures/https://leetcode.com/problems/daily-temperatures/



## 思路

给定每天的温度，求对于每一天需要等几天才可以等到更暖和的一天。如果该天之后不存在更暖和的天气，则记为0。

设置一个栈，其中保存的为温度单调递减的日期。对于next天，遍历栈内元素。

如果当天的温度小于等于栈顶元素，说明当天的温度没有比栈里的日子更暖和，将next入栈，不再遍历，等待温暖的日子到来；如果当天的温度大于栈顶的温度，出栈日期preIndex，并且更新 结果数组 (next-preIndex)，继续遍历。

## Java

```java
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> decStack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i=0; i<temperatures.length; i++) {
            while (!decStack.empty()) {
                int preIndex = decStack.peek();
                if (temperatures[i] <= temperatures[preIndex]) {
                    break;
                }
                decStack.pop();
                res[preIndex] = i -preIndex;
            }
            decStack.push(i);
        }
        return res;
    }
}
```

