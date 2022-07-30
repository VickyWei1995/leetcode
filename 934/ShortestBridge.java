package LeetCode;

import javax.management.MBeanRegistration;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    public static void main(String[] args) {
        int[][] grid = {
                {0,1,0},
                {0,0,0},
                {0,0,1},
        };
        int[][] grid2 = {
                {0,1},
                {1,0},
        };
        Solution s = new Solution();
        s.shortestBridge(grid2);
    }

    static class Solution {
        int[] loop = {-1,0,1,0,-1};

        public int shortestBridge(int[][] grid) {
            Queue<Point> points = new LinkedList<>();
            boolean isFind = false;
            for (int i=0; i<grid.length; i++) {
                if (isFind)
                    break;
                for (int j=0; j<grid[0].length;j++) {
                    if (grid[i][j] == 1) {
                        dfs(points,i,j,grid);
                        isFind = true;
                        break;
                    }
                }
            }
            int level = 0;
            //bfs
            while(!points.isEmpty()) {
                level++;
                // 记录当前level层的数量
                int nLevelNum = points.size();
                while (nLevelNum>0) {
                    nLevelNum--;
                    Point temp = points.poll();
                    for (int i=1; i< loop.length;i++) {
                        int row = temp.x+loop[i-1], col = temp.y+loop[i];
                        if (row<0 || col <0 || row>=grid.length || col>= grid[0].length) {
                            continue;
                        }
                        if (grid[row][col] == 2) {
                            continue;
                        }
                        if (grid[row][col] == 1) {
                            return level;
                        }
                        points.add(new Point(row, col));
                        grid[row][col] = 2;
                    }
                }
            }
            return -1;
        }

        private void dfs(Queue<Point> points, int x, int y, int[][] grid) {
            if (x<0 || y<0 || x>=grid.length || y>= grid[0].length) {
                return;
            }
            if (grid[x][y] == 2) {
                return;
            }
            if (grid[x][y] == 0) {
                grid[x][y] = 2;
                points.offer(new Point(x,y));
            } else {
                grid[x][y] = 2;
                for (int i=1; i<loop.length; i++) {
                    dfs(points, x+loop[i-1], y+loop[i], grid);
                }
            }
        }

        class Point {
            int x;
            int y;
            Point(int a, int b) {
                this.x = a;
                this.y = b;
            }
        }
    }

}
