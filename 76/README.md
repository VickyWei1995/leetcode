# 76 Minimum Window Substring

https://leetcode.com/problems/minimum-window-substring/

## Description

Given two strings `s` and `t` of lengths `m` and `n` respectively, return *the **minimum window substring** of* `s` *such that every character in* `t` *(**including duplicates**) is included in the window. If there is no such substring**, return the empty string* `""`*.*

The testcases will be generated such that the answer is **unique**.

A **substring** is a contiguous sequence of characters within the string.

 

## **Example 1:**

```
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
```

## **Example 2:**

```
Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
```

## Example 3:

```
Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
```



## **Constraints:**

- `m == s.length`
- `n == t.length`
- `1 <= m, n <= 105`
- `s` and `t` consist of uppercase and lowercase English letters.



## 思路

在S中查找包含T的最短子串。先遍历T，统计每个字母出现的次数。遍历S，右指针先移动，从左往右遍历，如果找到了匹配的，相应的字母次数减少，字母都找到之后，开始移动左指针；左指针，从左往右移动，如果找到了匹配的，相应的字母次数增加，字母数量不满足要求后，继续移动右指针。

## Java

```java
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> charCounts = new HashMap<>();   // 统计字符的出现次数
        for (int i=0; i<t.length(); i++) {
            if (!charCounts.containsKey(t.charAt(i))) {
                charCounts.put(t.charAt(i), 0);
            }
            charCounts.put(t.charAt(i), charCounts.get(t.charAt(i))+1);
        }

        int r=0, l=0, minSize = s.length() + 1, minL = 0, count =0;
        for (; r<s.length(); r++) {
            if (charCounts.containsKey(s.charAt(r))) {
                charCounts.put(s.charAt(r), charCounts.get(s.charAt(r))-1);
                if (charCounts.get(s.charAt(r)) >= 0) {
                    ++count;
                }
            }
            while (count == t.length()) {
                if (r-l+1 < minSize) {
                    minSize = r-l+1;
                    minL = l;
                }
                if (charCounts.containsKey(s.charAt(l))) {
                    charCounts.put(s.charAt(l), charCounts.get(s.charAt(l))+1);
                    if (charCounts.get(s.charAt(l)) > 0) {
                        --count;
                    }
                }
                l++;
            }
        }
        return minSize > s.length() ? "" : s.substring(minL, minL+minSize);
    }
}
```

