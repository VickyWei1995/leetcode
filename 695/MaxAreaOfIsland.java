package LeetCode;

public class MaxAreaOfIsland {
    public static void main(String[] args) {

    }

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
}


