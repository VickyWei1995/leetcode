# 122 Best Time to Buy and Sell Stock II

https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/



## 思路

给定一段时间内每天的股票价格，已知可以买卖多次，但同一时间段只能保留一只股票，求最大的收益.

相当于每个递增的区间中进行一次买卖。设置subResult记录每个递增区间的收益，设置result为所有subResult的和。遍历一遍，如果i<i-1，说明非递增，区间需要重置

## Java

```java
class Solution {
    public int maxProfit(int[] prices) {
        int result=0,subResult=0, buy=prices[0];
        for (int i=1; i<prices.length; i++) {
            if (prices[i] < prices[i-1]) {
                buy = prices[i];
                result += subResult;
                subResult = 0;
            } else {
                subResult = prices[i]-buy;
            }
        }
        result += subResult;
        return result;
    }
}
```

