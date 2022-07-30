package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {

    }

    class Solution {
        public List<List<String>> solveNQueens(int n) {
            int[] resultArr = new int[n];
            for (int i=0; i<n; i++) {
                resultArr[i] = -1;
            }
            List<List<String>> result = new ArrayList<>();
            helper(result, resultArr, 0);
            return result;
        }

        private void helper(List<List<String>> result, int[] resultArr, int row) {
            if (row == resultArr.length) {
                List<String> temp = new ArrayList<>();
                String s = String.join("", Collections.nCopies(resultArr.length, String.valueOf('.')));
                StringBuilder sb = new StringBuilder(s);
                for (int i=0; i<resultArr.length;i++) {
                    sb.setCharAt(resultArr[i], 'Q');
                    temp.add(sb.toString());
                    sb.setCharAt(resultArr[i], '.');
                }
                result.add(temp);
            }
            for (int col=0; col<resultArr.length; col++) {
                if (checkIfValid(resultArr, row, col)) {
                    resultArr[row] = col;
                    helper(result, resultArr, row+1);
                    resultArr[row] = -1;
                }
            }
        }

        private boolean checkIfValid(int[] resultArr, int row, int col){
            for (int i=0; i<row;i++) {
                // resultArr[i] == col 判断到前面已经有皇后占据了col列，不符合条件
                // Math.abs(row-i) == Math.abs(resultArr[i] - col) 判断到有2个皇后处于同一斜线上，不符合条件
                if (resultArr[i] == col || Math.abs(row-i) == Math.abs(resultArr[i] - col)) {
                    return false;
                }
            }
            return true;
        }
    }
}
