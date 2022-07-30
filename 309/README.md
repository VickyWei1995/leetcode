# 142 Best Time to Buy and Sell Stock with Cooldown

https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/



## 思路

给定一段时间内每天的股票价格，已知每次卖出之后必须冷却一天，且每次只能拥有一支股票，求最大的收益。

维护三个一维数组buy, sell。其中：

buy[i]表示在第i天之前最后一个操作是买，此时的最大收益。

sell[i]表示在第i天之前最后一个操作是卖，此时的最大收益。

状态转移方程：

buy[i] = max(sell[i-2]-price, buy[i-1])  情况一，当天进行了买的操作；情况二，当天未进行任何操作

sell[i] = max( buy[i-1]+price, sell[i-1] ) 情况一，当天进行了卖的操作；情况二，当天未进行任何操作

## Java

```java
class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        // 第i天的最后一个操作为buy
        int[] buy = new int[len+1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        // 第i天的最后一个操作为sell
        int[] sell = new int[len+1];
        for (int i=1; i<=len; i++) {
            if (i<2) {
                buy[i] = Math.max(0-prices[i-1], buy[i-1]);
            } else {
                buy[i] = Math.max(sell[i-2]-prices[i-1], buy[i-1]);
            }
            sell[i] =  Math.max(buy[i-1]+prices[i-1], sell[i-1]);
        }
        return sell[len];
    
    }
}
```

