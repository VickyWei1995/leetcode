# 64 Minimum Path Sum

https://leetcode.com/problems/minimum-path-sum/



## 思路

给定一个m * n 大小的非负整数矩阵，求从左上角开始到右下角结束的、经过的数字的和最小的路径。每次只能向右或者向下移动。

我们可以定义一个同样是二维的dp 数组，其中dp[i][j] 表示从左上角开始到(i, j) 位置的最优路径的数字和。因为每次只能向下或者向右移动，我们可以很容易得到状态转移方程dp[i][j] =min(dp[i-1][j], dp[i][j-1]) + grid[i][j]，其中grid 表示原数组。

## Java

```java
class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
            int row = grid.length, col = grid[0].length;
            for (int i=row-1; i>=0; i--) {
                for(int j=col-1; j>=0; j--) {
                    // right
                    int right = -1;
                    if (j+1<col) {
                        right = dp[i][j+1];
                    }
                    // down
                    int down = -1;
                    if (i+1<row) {
                        down = dp[i+1][j];
                    }
                    if (right != -1 && down != -1) {
                       dp[i][j] = grid[i][j] + Math.min(right, down);
                    } else if (down == -1 && right == -1) {
                        dp[i][j] = grid[i][j];
                    } else if (right == -1) {
                        dp[i][j] = grid[i][j] + down;
                    } else {
                        dp[i][j] = grid[i][j] + right;
                    }
                }
            }
            return dp[0][0];
    }
}
```

