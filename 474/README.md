# 474 Ones and Zeroes

https://leetcode.com/problems/ones-and-zeroes/



## 思路

 Ones and Zeroes (Medium)  给定m 个数字0 和n 个数字1，以及一些由0-1 构成的字符串，求利用这些数字最多可以构成多少个给定的字符串，字符串只可以构成一次。

这个可以看做多维的背包问题。在未使用空间压缩算法之前，我们应该需要设置一个3维的组数，如果使用空间压缩算法的话，只需要一个二维数组，m*n。状态转移方程 dp[i][j] = Math.max(dp[i][j], dp[i-m1][j-n1] )



## Java

```java
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1]; 
        int result = 0;
        for (String s: strs) {
            int m1 = (int) s.chars().filter(ch -> ch == '0').count();
            int n1 = (int) s.chars().filter(ch -> ch == '1').count();
            for (int j=m; j>=m1 ;j--) {
                for (int k=n; k>=n1;k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j-m1][k-n1]+1);
                    result = Math.max(result, dp[j][k]);
                }
            } 
        }
        return result;
    }
}
```

