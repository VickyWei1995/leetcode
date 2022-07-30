# 79 Word Search

https://leetcode.com/problems/word-search/



## 思路

给定一个二维数组，里面都是char；查找数组中是否存在某个string。递归and回溯。对于i,j ，如果等于string[pos]，则对于其上下左右进行pos+1的判断。



## Java

```java
class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visitFlags = new boolean[board.length][board[0].length];
            int pos = 0;
            for (int i=0; i<=board.length; i++) {
                for (int j=0; j<board[0].length; j++) {
                    if (existHelper(board, word, visitFlags, pos, i, j)) {
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
```

