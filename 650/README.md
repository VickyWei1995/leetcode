# 650 2 Keys KeyboardI

https://leetcode.com/problems/2-keys-keyboard/

## 思路

2 Keys Keyboard (Medium)  给定一个字母A，已知你可以每次选择复制全部字符，或者粘贴之前复制的字符，求最少需要几次操作可以把字符串延展到指定长度。

不同于以往通过加减实现的动态规划，这里需要乘除法来计算位置，因为粘贴操作是倍数增加的。我们使用一个一维数组dp，其中位置i 表示延展到长度i 的最少操作次数。对于每个位置j，如果j 可以被i 整除，那么长度i 就可以由长度j 操作得到，其操作次数等价于把一个长度为1的A 延展到长度为i/j。因此我们可以得到递推公式dp[i] = dp[j] + i/j。



## Java

```java
class Solution {
    public int minSteps(int n) {
        if (n==1) {
            return 0;
        }
        int[] dp = new int[n+1];
        for (int i=2; i<=n;i++) {
            dp[i] = i;
            for (int j=i-1; j>1;j--) {
                if (i%j == 0) {
                    dp[i] = dp[j] + i/j;
                    break;
                }
            }
        }
        return dp[n];
    }
}
```

