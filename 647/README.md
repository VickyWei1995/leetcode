# 647 Palindromic Substrings

https://leetcode.com/problems/palindromic-substrings/



## 思路

给定一个字符，求其有多少个回文子字符串。回文的定义是左右对称。我们可以从字符串的每个位置开始，向左向右延长，判断存在多少以当前位置为中轴的回文子字符串。

## Java

```java
class Solution {
    public int countSubstrings(String s) {
        int[] res = new int[1];
        for (int i=0;i<s.length(); i++) {
            externString(i,i,res,s);
            externString(i,i+1,res,s);
        }
        return res[0];
    }
    private void externString(int l, int r, int[] res, String s) {
        while (l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
            res[0] += 1;
        }
    }
}
```

