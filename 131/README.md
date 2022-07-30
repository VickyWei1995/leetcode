# 131 Palindrome Partitioning

https://leetcode.com/problems/palindrome-partitioning/



## 思路

分割字符串，使分割后的子串都是回文字符串。DFS + 回溯法。设置一个startIndex，startIndex如果等于字符串 size，已找到符合要求的一个分割条件；否则，遍历子串(startIndex, i+1)，如果是回文，则设置一个分割点，startIndex +1继续递归，递归结束后，去除该分割点，i+1，继续遍历子串。

## Java

```java
class Solution {
    public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();
            List<String> subRes = new ArrayList<>();
            helper(s, 0, subRes, res);
            return res;
        }

        private void helper(String s, int startIndex, List<String> subRes, List<List<String>> res) {
            if (startIndex == s.length()) {
                List<String> dst = new ArrayList<>(subRes);
                res.add(dst);
                return;
            }
            for (int i=startIndex; i<s.length(); i++) {
                if (!isPalindrome(s, startIndex, i)) {
                    continue;
                }
                subRes.add(s.substring(startIndex, i+1));
                int curIndex = subRes.size()-1;
                helper(s, i+1, subRes, res);
                subRes.remove(curIndex);
            }
        }

        private boolean isPalindrome(String s, int begin, int end) {
            while (begin <= end) {
                if (s.charAt(begin) != s.charAt(end)) {
                    return false;
                }
                begin++;
                end--;
            }
            return true;
        }
}
```

