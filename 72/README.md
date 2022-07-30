# 72 Edit Distance

https://leetcode.com/problems/edit-distance/



## 思路

Edit Distance (Hard) 给定两个字符串，已知你可以删除、替换和插入任意字符串的任意字符，求最少编辑几步可以将两个字符串变成相同。

类似于题目1143，我们使用一个二维数组dp[i][j]，表示将第一个字符串到位置i 为止，和第二个字符串到位置j 为止，最多需要几步编辑。当第i 位和第j 位对应的字符相同时，dp[i][j] 等

于dp[i-1][j-1]；当二者对应的字符不同时，采取修改操作是dp[i-1][j-1]+1，采取插入操作是dp[i][j-1] + 1，采取删除操作是dp[i-1][j] + 1。



## Java

```java
class Solution {
    public int minDistance(String word1, String word2) {
        int row = word1.length(), col = word2.length();
        int[][] dp = new int[row+1][col+1];
        for (int i=0; i<=row; i++) {
            for(int j=0; j<=col; j++) {
                if (i==0) {
                        dp[i][j] = j;
                        continue;
                    }
                    if (j==0) {
                        dp[i][j] = i;
                        continue;
                    }
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    // 在i-1映射到j-1的基础上，replace i位置的字符 --> j
                    int replaceAction = dp[i-1][j-1] + 1;
                    // 在 i 映射到 j-1的基础上，添加 j位置的字符
                    int insertAction = dp[i][j-1] +1;
                    // 在 i-1 映射到 j的基础上，删除 i位置的字符
                    int removeAction = dp[i-1][j] + 1;
                    dp[i][j] = Math.min(Math.min(replaceAction, insertAction), removeAction);
                }
            }
        }
        return dp[row][col];
    }
}
```

