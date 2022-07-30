package LeetCode;

public class OnesAndZeroes {
    public static void main(String[] args) {

    }

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
}
