package LeetCode;

public class DecodeWays {
    public static void main(String[] args) {
        String test = "226";
        Solution s = new Solution();
        s.numDecodings(test);
    }

    static class Solution {
        public int numDecodings(String s) {
            int[] dp = new int[s.length()];
            if (s.charAt(0) == '0') {
                return 0;
            }
            dp[0] = 1;
            for (int i=1; i< s.length(); i++) {
                int tempResult = 0;
                if (s.charAt(i)!='0') {
                    tempResult += dp[i-1];
                }
                if (s.charAt(i-1)!='0' && Integer.parseInt(s.substring(i-1,i+1)) <= 26) {
                    if (i-2 >=0) {
                        tempResult += dp[i-2];
                    } else {
                        tempResult += 1;
                    }
                }
                dp[i] = tempResult;
            }
            return dp[s.length() -1];
        }
    }
}
