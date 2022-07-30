# 322 Coin Change

https://leetcode.com/problems/coin-change/

## 思路

Coin Change (Medium) 给定一些硬币的面额，求最少可以用多少颗硬币组成给定的金额。

这个可以看做一个完全背包问题。dp保存硬币的数量。初始化dp时，初始值需要大于最大可能出现的情况，即全部都是1元的情况。状态转移方程为：dp[j] = Math.min(dp[j], dp[j-w]+1);

## Java

```java
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i=0; i<coins.length; i++) {
            int w = coins[i];
            for (int j=w; j<=amount; j++) {
                dp[j] = Math.min(dp[j], dp[j-w]+1);
            }
        }
        if (dp[amount] > amount) {
            return -1;
        }
        return dp[amount];
    }
}
```

