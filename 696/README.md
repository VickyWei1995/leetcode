# 696 Count Binary Substrings

https://leetcode.com/problems/count-binary-substrings/



## 思路

给定一个0-1 字符串，求有多少非空子字符串的0 和1 数量相同。针对"00110011"的情况分析，当第一个1出现的时候，前面由于前面有两个0，所以肯定能组成01，再遇到下一个1时，此时1有2个，0有2个，能组成0011，下一个遇到0时，此时0的个数重置为1，而1的个数有两个，所以一定有10，同理，下一个还为0，就会有1100存在。因此我们可以遍历的时候统计当前连续字符的个数，当出现不同的字符时，判断数量，决定是否可以组成符合条件的字符串



## Java

```java
class Solution {
    public int countBinarySubstrings(String s) {
        int res = 0, cur = 1, last = -1;
        for (int i=1; i<s.length();i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                cur += 1;
            } else {
                last = cur;
                cur = 1;
            }
            if (last >= cur) {
                res ++;
            }
        }
        return res;
    }
}
```

