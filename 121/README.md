# 121 Best Time to Buy and Sell Stock

https://leetcode.com/problems/best-time-to-buy-and-sell-stock/



## 思路

给定一段时间内每天的股票价格，已知你只可以买卖各一次，求最大的收益.

我们可以遍历一遍数组，在每一个位置i 时，记录i 位置之前所有价格中的最低价格，然后将当前的价格作为售出价格，查看当前收益是不是最大收益即可。



## Java

```java
class Solution {
    public int maxProfit(int[] prices) {
        int result = 0, buy = prices[0];
        for(int i=1; i<prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else {
                result = Math.max(prices[i] - buy, result);
            }
        }
        return result;
    }
}
```

