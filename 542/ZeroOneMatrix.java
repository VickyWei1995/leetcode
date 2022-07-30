package LeetCode;

import java.util.Arrays;

public class ZeroOneMatrix {
    public static void main(String[] args) {

    }

    class Solution {
        int[] loop = {-1,0,1,0,-1};
        public int[][] updateMatrix(int[][] mat) {
            int[][] results = new int[mat.length][mat[0].length];
            for (int i=0; i<results.length; i++) {
                Arrays.fill(results[i], -1);
            }
            for (int i=0; i<results.length;i++) {
                for (int j =0; j<results[i].length;j++) {
                    minDistance(mat,results,i,j);
                }
            }
            return results;
        }

        private int minDistance(int[][] mat, int[][] results, int row, int col) {
            if (row<0 || row>=mat.length || col<0 || col >= mat[0].length) {
                return -1;
            }
            if (mat[row][col] == 0) {
                results[row][col] = 0;
            }
            if (results[row][col] != -1) {
                return results[row][col];
            }
            int minDis = mat.length + mat[0].length;
            for (int i=1; i< loop.length;i++) {
                int x = row + loop[i - 1], y = col + loop[i];
                int tempMinDis = minDistance(mat,results,x, y);
                if (tempMinDis != -1) {
                    minDis = Math.min(tempMinDis+1, minDis);
                }
            }
            results[row][col] = minDis;
            return results[row][col];
        }
    }

    class Solution1 {
        public int[][] updateMatrix(int[][] mat) {
            int[][] result = new int[mat.length][mat[0].length];
            for (int i=0; i<mat.length; i++) {
                Arrays.fill(result[i], Integer.MAX_VALUE-1);
            }
            int row = mat.length, col = mat[0].length;
            for (int i=0; i<row; i++) {
                for (int j=0; j<col; j++) {
                    if (mat[i][j] == 0) {
                        result[i][j] = 0;
                        continue;
                    }
                    if (i>0) {
                        result[i][j] = Math.min(result[i][j], result[i-1][j]+1);
                    }
                    if (j>0) {
                        result[i][j] = Math.min(result[i][j], result[i][j-1]+1);
                    }
                }
            }
            for (int i=row-1; i>=0; i--) {
                for (int j=col-1; j>=0; j--) {
                    if (mat[i][j] == 0) {
                        continue;
                    }
                    if (i+1<row) {
                        result[i][j] = Math.min(result[i][j], result[i+1][j]+1);
                    }
                    if (j+1<col) {
                        result[i][j] = Math.min(result[i][j], result[i][j+1]+1);
                    }
                }
            }
            return result;
        }
    }
}
