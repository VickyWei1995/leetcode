# 279 Perfect Squares

https://leetcode.com/problems/perfect-squares/



## 思路

Perfect Squares (Medium)  给定一个正整数，求其最少可以由几个完全平方数相加构成。我们定义一个一维矩阵dp，其中dp[i] 表示数字i 最少可以由几个完全平方数相加

构成。在本题中，位置i 只依赖i - k2 的位置，如i - 1、i - 4、i - 9 等等，才能满足完全平方分割的条件。

## Java

```java
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n];
        for (int i=0; i<n;i++) {
            helper(i+1, dp);
        }
        return dp[n-1];
        
    }
    
    private void helper(int n, int[] dp) {
        int maxSquare = (int) Math.sqrt(n);
        int min = n;
        for (int i=1; i<=maxSquare; i++) {
            if (n-i*i <= 0) {
                min = 1;
            } else {
                min = Math.min(min,1+dp[n-i*i-1]);
            }
        }
        dp[n-1] = min;
        return;
    }
}
```

