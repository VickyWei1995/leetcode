# 240 Search a 2D Matrix II

https://leetcode.com/problems/search-a-2d-matrix-ii/



## 思路

给定一个二维矩阵，已知每行和每列都是增序的，尝试设计一个快速搜索一个数字是否在矩阵中存在的算法。

这道题有一个简单的技巧：我们可以从右上角开始查找，若当前值大于待搜索值，我们向左移动一位；若当前值小于待搜索值，我们向下移动一位

## Java

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n=matrix[0].length;
        int row=0, col=0;
        while(row<m && col<n && matrix[row][col] <= target) {
            if (matrix[row][col] == target) {
                return true;
            }
            row++;
            col++;
        }

        for (int i=0;i<row;i++) {
            for (int j=col; j<n;j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            } 
        }
        for (int j=0;j<col;j++) {
            for (int i=row; i<m;i++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            } 
        }
        return false;
    }
}
```

