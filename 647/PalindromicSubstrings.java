package LeetCode;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        String test = "00110011";
        Solution s = new Solution();
        s.countBinarySubstrings(test);
    }

    static class Solution {
        public int countBinarySubstrings(String s) {
            int[][] dp = new int[s.length()][s.length()];
            int res = 0;
            for (int i=0; i<dp.length;i++) {
                int temp = 0;
                for(int j=i; j<dp.length; j++) {
                    if (j>i) {
                        temp = dp[i][j-1];
                    }
                    if (s.charAt(j) == '1') {
                        dp[i][j] = temp + 1;
                    } else {
                        dp[i][j] = temp - 1;
                    }
                    if (dp[i][j] == 0) {
                        res +=1;
                    }
                }
            }
            return res;
        }
    }
}
