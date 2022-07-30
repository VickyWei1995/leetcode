package LeetCode;

public class PerfectSquares {
    public static void main(String[] args) {
        int n = 12;
        Solution s = new Solution();
        int result = s.numSquares(n);
        System.out.print(result);
    }

    static class Solution {
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
}
