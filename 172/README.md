# 172 Factorial Trailing Zeroes

https://leetcode.com/problems/factorial-trailing-zeroes/



## 思路

给定一个非负整数，判断它的阶乘结果的结尾有几个0。

每个尾部的0 由2   5 = 10 而来，因此我们可以把阶乘的每一个元素拆成质数相乘，统计有多少个2 和5。明显的，质因子2 的数量远多于质因子5 的数量，因此我们可以只统计阶乘结果里有多少个质因子5。

## Java

```java
class Solution {
    public int trailingZeroes(int n) {
        return n==0?0:n/5+trailingZeroes(n/5);
    }
}
```

