# 542 01 Matrix

https://leetcode.com/problems/01-matrix/



## 思路

01 Matrix (Medium) 给定一个由0 和1 组成的二维矩阵，求每个位置到最近的0 的距离。一种办法是使用一个dp 数组做 memoization，使得广度优先搜索不会重复遍历相同位置；另一种更简单的方法是，我们从左上到右下进行一次动态搜索，再从右下到左上进行一次动态搜索。两次动态搜索即可完成四个方向上的查找。



## Java

```java
class Solution {
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
```

