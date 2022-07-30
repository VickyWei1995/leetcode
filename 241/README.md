# 241 Different Ways to Add Parentheses

https://leetcode.com/problems/different-ways-to-add-parentheses/



## 思路

给定一个只包含加、减和乘法的数学表达式，求通过加括号可以得到多少种不同的结果。

题目可以变成 () ? () 这种形式，两个括号内分别是各自的表达式，最终会分别计算得到两个整型数组，中间的问号表示运算符，可以是加，减，或乘。左括号即 substring(0,i) 的结果，右括号即substring(i+1) 的结果。

## Java

```java
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0,i));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1));
                for (int l:left) {
                    for (int r: right) {
                        switch(expression.charAt(i)) {
                            case '+':
                                result.add(l+r);
                                break;
                            case '-':
                                result.add(l-r);
                                break;
                            default:
                                result.add(l*r);
                                break;
                        }
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.parseInt(expression));
        }
        return result;
    }
}
```

