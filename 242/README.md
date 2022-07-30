# 242 Valid Anagram

https://leetcode.com/problems/valid-anagram/



## 思路

判断两个字符串包含的字符是否完全相同。 以利用哈希表或者数组统计两个数组中每个数字出现的频次，若频次相同，则说明它们包含的字符完全相同。

## Java

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> sMap = new HashMap<>();
            for (char c = 'a'; c<='z'; c++) {
                sMap.put(c,0);
            }
            for (int i=0; i<s.length();i++) {
                int cur = sMap.get(s.charAt(i)) + 1;
                sMap.put(s.charAt(i), cur);
            }

            for (int i=0; i<t.length(); i++) {
                int cur = sMap.get(t.charAt(i)) - 1;
                sMap.put(t.charAt(i), cur);
            }
            for (char key: sMap.keySet()) {
                if (sMap.get(key) != 0) {
                    return false;
                }
            }
            return true;
    }
}
```

