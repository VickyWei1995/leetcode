# 338 Counting Bits

https://leetcode.com/problems/counting-bits/



## 思路

给定一个非负整数n，求从0 到n 的所有数字的二进制表达中，分别有多少个1。

本题可以利用动态规划和位运算进行快速的求解。定义一个数组dp，其中dp[i] 表示数字i的二进制含有1 的个数。对于第i 个数字，如果它二进制的最后一位为1，那么它含有1 的个数则为dp[i-1] + 1；如果它二进制的最后一位为0，那么它含有1 的个数和其算术右移结果相同，即dp[i>>1]。

## Java

```java
class Solution {
    public int[] countBits(int n) {
        int[] results = new int[n+1];
        for (int i=1; i<=n; i++) {
            results[i] = (i&1)==1 ? results[i-1]+1 : results[i>>1];
        }
        return results;
    }
}
```

