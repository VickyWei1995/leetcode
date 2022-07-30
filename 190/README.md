# 190 Reverse Bits

https://leetcode.com/problems/reverse-bits/



## 思路

给定一个十进制整数，输出它在二进制下的翻转结果。使用算术左移和右移。我们每次取n的最后一位数字，将这位数字不断左移；n不断右移，更新最后一位数字

## Java

```java
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for (int i=0; i<32; i++) {
            ans <<= 1;
            ans += n & 1;
            n >>= 1;
        }
        return ans;
        
    }
}
```

