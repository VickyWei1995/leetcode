# 461 Hamming Distance

https://leetcode.com/problems/hamming-distance/



## 思路

给定两个十进制数字，求它们二进制表示的汉明距离（Hamming distance，即不同位的个数）。对两个数进行按位异或操作，统计有多少个1 即可。

## Java

```java
class Solution {
    public int hammingDistance(int x, int y) {
        int diff = x^y, res = 0;
        while(diff > 0) {
            res += diff & 1;
            diff >>=1;
        }
        return res;
    }
}
```

