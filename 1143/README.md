# 1143 Longest Common Subsequence

https://leetcode.com/problems/longest-common-subsequence/



## 思路

给定两个字符串，求它们最长的公共子序列长度。 

以建立一个二维数组dp，其中dp[i][j] 表示到第一个字符串位置i 为止、到第二个字符串位置j 为止、最长的公共子序列长度。dp方程：

```java
if (text[i-1] == text2[j-1]) {
  dp[i][j] = dp[i-1][j-1] + 1;
} else {
  dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
}
```



## Java

```java
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
       int[][] dp = new int[text1.length()+1][text2.length()+1];
            for (int i=1; i<=text1.length(); i++) {
                for(int j=1; j<=text2.length(); j++) {
                    if (text1.charAt(i-1) == text2.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
            return dp[text1.length()][text2.length()];
    }
}
```

