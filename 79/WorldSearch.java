package LeetCode;

public class WorldSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}
        };
        String world = "ABCDE";
        Solution s = new Solution();
        s.exist(board, world);
    }

    static class Solution {
        public boolean exist(char[][] board, String word) {
            boolean[][] visitFlags = new boolean[board.length][board[0].length];
            for (int i=0; i<=board.length; i++) {
                for (int j=0; j<board[0].length; j++) {
                    if (existHelper(board, word, visitFlags, 0, i, j)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean existHelper(char[][] board, String word, boolean[][] visitFlags, int pos, int x, int y) {
            if (x<0 || y<0 || x>=board.length || y>= board[0].length) {
                return false;
            }
            if (visitFlags[x][y] || board[x][y] != word.charAt(pos)) {
                return false;
            }
            if (pos == word.length() -1) {
                return true;
            }
            visitFlags[x][y] = true;
            boolean find = false;
            int[] loop = {-1,0,1,0,-1};
            int loopIndex = 1;
            while ((!find) && (loopIndex < loop.length) ) {
                find |= existHelper(board, word, visitFlags, pos+1, x+loop[loopIndex-1], y+loop[loopIndex]);
                loopIndex++;
            }
            visitFlags[x][y] = false;
            return find;
        }
    }
}
