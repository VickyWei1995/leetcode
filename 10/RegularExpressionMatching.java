package LeetCode;

public class RegularExpressionMatching {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean isMatch(String s, String p) {
            int row = s.length(), col = p.length();
            boolean[][] dp = new boolean[row+1][col+1];
            dp[0][0]  = true;
            for (int i=0; i<=row; i++) {
                for (int j=1; j<=col;j++) {
                    // 当前pattern是 . 可以匹配任意字符
                    if (p.charAt(j-1) == '.') {
                        dp[i][j] = i>0 && dp[i-1][j-1];
                    }
                    // 当前pattern是字符. 对应的字符需要和s的相同
                    else if (p.charAt(j-1) != '*') {
                        dp[i][j] = i>0 && dp[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1));
                    }
                    // 当前pattern是*,匹配至少1次 dp[i][j] = dp[i-1][j]
                    // 当前pattern是*,匹配0次 dp[i][j] = dp[i][j-2]
                    else {
                        dp[i][j] = dp[i][j-2] ||
                            (i>0 && dp[i - 1][j]
                            && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.'));
                    }

                }
            }
            return dp[row][col];
        }
    }
}
