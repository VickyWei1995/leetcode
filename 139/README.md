# 139 Word Break

https://leetcode.com/problems/word-break/



## 思路

给定一个字符串和一个字符串集合，求是否存在一种分割方式，使得原字符串分割后的子字符串都可以在集合内找到。类似于完全平方数分割问题，这道题的分割条件由集合内的字符串决定，因此在考虑每个分割位置时，需要遍历字符串集合，以确定当前位置是否可以成功分割。

## Java

```java
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] tempResult = new boolean[s.length()];
        for(int i=0; i<s.length();i++) {
            if (wordDict.contains(s.substring(0,i+1))) {
                    tempResult[i] = true;
                    continue;
                }
            for (int j=i-1; j>=0; j--) {
                if (tempResult[j] && wordDict.contains(s.substring(j+1,i+1))) {
                    tempResult[i] = true;
                    break;
                }
            }
            
        }
        return tempResult[s.length()-1];
    }
    
}
```

