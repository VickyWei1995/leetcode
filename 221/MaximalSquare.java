package LeetCode;

public class MaximalSquare {
    public static void main(String[] args) {

    }

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
            return result;
        }
    }
}
