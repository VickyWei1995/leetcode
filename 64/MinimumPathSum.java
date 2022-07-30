package LeetCode;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {
                {1,3,1},{1,5,1},{4,2,1}
        };
        Solution s = new Solution();
        s.minPathSum(grid);
    }

    static class Solution {
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

}
