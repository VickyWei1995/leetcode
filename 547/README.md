# 547 Number of Provinces

https://leetcode.com/problems/number-of-provinces/



## 思路

给一个n*n的二维  数组，1表示城市i 和 城市j 相邻，相邻的关系可以传递，求有几个城市圈。利用DFS，先对城市i搜索，如果有相邻的城市j，则对城市j进行搜索。搜索过的元素需要进行标记。

## Java

```java
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int result = 0;
            for (int i=0; i<isConnected.length; i++) {
                for (int j=i; j<isConnected.length; j++) {
                    if (isConnected[i][j] == 1) {
                        dfs(isConnected, i);
                        result += 1;
                    }
                }
            }
            return result;
    }
    private void dfs(int[][] isConnected, int currentIndex) {
            isConnected[currentIndex][currentIndex] = 0;
            for (int i=0; i<isConnected.length; i++) {
                if (isConnected[currentIndex][i] == 1) {
                    isConnected[currentIndex][i] = 0;
                    dfs(isConnected, i);
                }
            }
        }
}
```

