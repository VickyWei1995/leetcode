# 221 Maximal Square

https://leetcode.com/problems/maximal-square/

## 思路

给定一个二维的0-1 矩阵，求全由1 构成的最大正方形面积。设置一个dp数组，dp数组中的每个元素表示以(i, j) 为右下角的正方形的边长。如果当前位置是0，那么dp[i][j] 即为0；如果当前位置是1，那么dp[i][j] = k，其充分条件为dp[i-1][j-1]、dp[i][j-1] 和dp[i-1][j] 的值必须都不小于 k-1。



## Java

```java
class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int result = 0;
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                    continue;
                }
                if (i-1<0 || j-1<0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        
        return result * result;
    }
}
```

