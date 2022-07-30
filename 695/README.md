# 695 Max Area of Island

https://leetcode.com/problems/max-area-of-island/

## Description

You are given an `m x n` binary matrix `grid`. An island is a group of `1`'s (representing land) connected **4-directionally** (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The **area** of an island is the number of cells with a value `1` in the island.

Return *the maximum **area** of an island in* `grid`. If there is no island, return `0`.

 

## **Example 1:**

![img](https://assets.leetcode.com/uploads/2021/05/01/maxarea1-grid.jpg)

```
Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.
```

## **Example 2:**

```
Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0
```

 

## **Constraints:**

- `m == grid.length`
- `n == grid[i].length`
- `1 <= m, n <= 50`
- `grid[i][j]` is either `0` or `1`.



## 思路

给定一个二维数组，数字1连起来的最大区域。利用搜索算法去做，对于当前为1的元素，标记其为0，且对其上下左右4个方向进行递归。

## Java

```java
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
            for (int i=0; i<grid.length; i++) {
                for (int j=0; j<grid[i].length; j++) {
                    if (grid[i][j] == 0) {
                        continue;
                    }
                    result = Math.max(result, area(grid, i, j));
                }
            }
            return result;
    }
    
    private int area(int[][] grid, int x, int y) {
            if (x<0 || y<0 || x>=grid.length || y>=grid[x].length || grid[x][y] == 0) {
                return 0;
            }
            grid[x][y] = 0;
            return area(grid, x-1, y) + area(grid, x+1, y) +
                    area(grid,x,y-1) + area(grid,x,y+1) + 1;
        }
}
```

