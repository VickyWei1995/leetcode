# 934 Shortest Bridge

https://leetcode.com/problems/shortest-bridge/





## 思路

给定一个二维数组，1代表陆地，0代表海洋。数组中有且仅有2块陆地。求最小的填海面积，使2块陆地相连。

这里其实就是想找2块陆地之间的最短距离。先用dfs找出其中一块陆地，dfs的时候将第一块陆地改为2，查找过程中遇到的0，放入队列中，且也修改为2。修改为2，是为了做标记，避免重复遍历。放入队列中的，即第一块陆地的边缘，可以认为是level为1的海洋区域。

接下来进行bfs，对于队列中的元素，进行出队，先出队level为1的这层元素。对于这层元素，如果相邻的有陆地，说明这层中就可以找到最短距离，最短距离就是1。没有找到陆地的话，就对第二层进行搜索。

## Java

```java
class Solution {
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
```

