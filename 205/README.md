# 205 Isomorphic Strings

https://leetcode.com/problems/isomorphic-strings/



## 思路

判断两个字符串是否同构。同构的定义是，可以通过把一个字符串的某些相同的字符转换成另一些相同的字符，使得两个字符串相同，且两种不同的字符不能够被转换成同一种字符。：记录两个字符串每个位置的字符第一次出现的位置，如果两个字符串中相同位置的字符与它们第一次出现的位置一样，那么这两个字符串同构

## Java

```java
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] sMap = new int[256];
        int[] tMap = new int[256];
        for (int i=0; i<s.length(); i++) {
            if (sMap[s.charAt(i)] != tMap[t.charAt(i)]) {
                return false;
            }
            sMap[s.charAt(i)] = tMap[t.charAt(i)] =i+1;
        }
        return true;
    }
}
```

