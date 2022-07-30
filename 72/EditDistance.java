package LeetCode;

public class EditDistance {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        Solution s = new Solution();
        s.minDistance(word1, word2);
    }

    static class Solution {
        public int minDistance(String word1, String word2) {
            int row = word1.length(), col = word2.length();
            int[][] dp = new int[row+1][col+1];
            for (int i=0; i<=row; i++) {
                for(int j=0; j<=col; j++) {
                    if (i==0) {
                        dp[i][j] = j;
                        continue;
                    }
                    if (j==0) {
                        dp[i][j] = i;
                        continue;
                    }
                    if (word1.charAt(i-1) == word2.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        // 在i-1映射到j-1的基础上，replace i位置的字符 --> j
                        int replaceAction = dp[i-1][j-1] + 1;
                        // 在 i 映射到 j-1的基础上，添加 j位置的字符
                        int insertAction = dp[i][j-1] +1;
                        // 在 i-1 映射到 j的基础上，删除 i位置的字符
                        int removeAction = dp[i-1][j] + 1;
                        dp[i][j] = Math.min(Math.min(replaceAction, insertAction), removeAction);
                    }
                }
            }
            return dp[row][col];
        }
    }
}

