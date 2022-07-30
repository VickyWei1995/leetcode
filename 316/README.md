# 316 Remove Duplicate Letters

https://leetcode.com/problems/remove-duplicate-letters/



## 思路

移除重复字母。先遍历，统计字母出现的次数；二次遍历的时候，出现次数-1，如果该字母的visited为true，说明先前已经访问过，且放置在合适的位置，continue；如果该字母的visited为false，对于结果数组逆序遍历，删除字典序大于该字母且出现次数大于0的字母，删除的字母的visited 需要修改为false。

## Java

```java
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
            boolean[] visited = new boolean[26];
            List<Character> res = new ArrayList<>();
            res.add('0');
            for (int i=0; i<s.length(); i++) {
                int charIndex = s.charAt(i) - 'a';
                count[charIndex]++;
            }

            for (int i=0; i<s.length(); i++) {
                int charIndex = s.charAt(i) - 'a';
                count[charIndex]--;
                if (visited[charIndex]) {
                    continue;
                }
                while (s.charAt(i) < res.get(res.size() -1) && count[res.get(res.size() -1)-'a']>0) {
                    visited[res.get(res.size() -1)-'a'] = false;
                    res.remove(res.size()-1);
                }
                res.add(s.charAt(i));
                visited[charIndex] = true;
            }
            res.remove(0);
            return res.stream().map(String::valueOf).collect(Collectors.joining());
        }

        private void checkMove(char c, List<Character> res) {
            int findIndex = res.indexOf(c);
            if (findIndex == res.size() - 1) {
                return;
            }
            int bigIndex = -1, smallIndex = -1;
            for (int i=findIndex+1; i<res.size(); i++) {
                if (res.get(i) < c && smallIndex < 0) {
                    smallIndex = i;
                } else if (res.get(i) > c && bigIndex < 0) {
                    bigIndex = i;
                }
            }
            if (smallIndex >= 0 && (bigIndex > smallIndex || bigIndex < 0)) {
                res.remove(findIndex);
                res.add(c);
            }
            return;
        }
}
```

