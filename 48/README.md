# 48 Rotate Image

https://leetcode.com/problems/rotate-image/



## 思路

给定一个n   n 的矩阵，求它顺时针旋转90 度的结果，且必须在原矩阵上修改（in-place）。怎样能够尽量不创建额外储存空间呢？ 正方形的四个角的元素旋转后依然在四个角。因此，我们可以每次swap 4个元素。

## Java

```java
class Solution {
    public void rotate(int[][] matrix) {
        for (int i=0; i<matrix.length; i++) {
            for(int j=i+1; j<matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix.length/2;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }
}
```

