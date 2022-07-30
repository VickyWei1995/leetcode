# 342 Power of Four

https://leetcode.com/problems/power-of-four/



## 思路

给定一个整数，判断它是否是4 的次方。

只有一个1，且1的位置必须为奇数。

首先我们考虑一个数字是不是2 的（整数）次方：如果一个数字n 是2 的整数次方，那么它的二进制一定是0...010...0 这样的形式；考虑到n 􀀀 1 的二进制是0...001...1，这两个数求按位与的结果一定是0。因此如果**n & (n - 1) 为0**，那么这个数是2 的次方。

如果这个数也是**4 的次方**，那二进制表示中1 的位置必须为**奇数位**。我们可以把n 和二进制的10101...101（即十进制下的1431655765）做按位与，如果结果不为0，那么说明这个数是4 的次方。

## Java

```java
class Solution {
    public boolean isPowerOfFour(int n) {
        int index = 1;
            int count = 0;
            while(n>0) {
                if((n & 1) == 0) {
                    index++;
                } else {
                    count++;
                }
                n >>= 1;
            }
            return index %2 == 1 && count == 1;
    }
}
```

