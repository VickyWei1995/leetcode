# 395 Longest Substring with At Least K Repeating Characters

https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/



## 思路

查找一个最长子串，该子串中的所有字符的重复次数都大于等于k。

1. i 初始化为0，代表查找子串的起始位置。
2. 从起始位置 i 进行遍历直到string的结束位置，如果有符合条件的子串，更新结果子串，i 更新为 结果子串的结尾index + 1；如果没有找到符合条件的子串，i ++。
3. 重复步骤2

## Java

```java
class Solution {
    public int longestSubstring(String s, int k) {
        int i =0;
            int n = s.length();
            int resLen = 0;
            while (i+k <= n) {
                int nextBeginIndex = i;
                int[] charCount = new int[26];
                int mask = 0;
                for (int j=i; j<n; j++) {
                    int charIndex = s.charAt(j) - 'a';
                    charCount[charIndex] += 1;
                    if (charCount[charIndex] >= k) 
                        mask &= ~(1 << charIndex);
                    else
                        mask |= (1 << charIndex);
                    if (mask == 0) {
                        resLen = Math.max(resLen, j-i+1);
                        nextBeginIndex = j;
                    }
                }
                i = nextBeginIndex + 1;
            }
            return resLen;
    }
}
```

