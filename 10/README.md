# 10 Regular Expression Matching

https://leetcode.com/problems/regular-expression-matching/



## 思路

Regular Expression Matching (Hard)  给定一个字符串和一个正则表达式（regular expression, regex），求该字符串是否可以被匹配。

我们可以使用一个二维数组dp，其中dp[i][j] 表示以i 截止的字符串是否可以被以j 截止的正则表达式匹配。根据正则表达式的不同情况，即字符、星号，点号，我们可以分情况讨论来更新dp 数组。

## Java

```java
    public boolean isMatch(String s, String p) {
        int row = s.length(), col = p.length();
        boolean[][] dp = new boolean[row+1][col+1];
        dp[0][0]  = true;
        for (int i=0; i<=row; i++) {
            for (int j=1; j<=col;j++) {
                // 当前pattern是 . 可以匹配任意字符
                if (p.charAt(j-1) == '.') {
                    dp[i][j] = i>0 && dp[i-1][j-1];
                }
                // 当前pattern是字符.对应的字符需要和s的相同
                else if (p.charAt(j-1) != '*') {
                    dp[i][j] = i>0 && dp[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1));
                }
                // 当前pattern是*,匹配至少1次 dp[i][j] = dp[i-1][j]
                // 当前pattern是*,匹配0次 dp[i][j] = dp[i][j-2]
                else {
                    dp[i][j] = dp[i][j-2] || (i>0 && dp[i - 1][j] && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.'));
                }
                
            }
        }
        return dp[row][col];
    }
}
```

