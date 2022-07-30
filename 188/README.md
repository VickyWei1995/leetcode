# 188 Best Time to Buy and Sell Stock IV

https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/



## 思路

给定一段时间内每天的股票价格，已知你只可以买卖各k 次，且每次只能拥有一支股票，求最大的收益。

如果k 大约总天数，那么我们一旦发现可以赚钱就进行买卖，这道题目简化为122。如果k 小于总天数，我们可以建立两个动态规划数组buy 和sell，对于每天的股票价格，buy[j] 表示在第j 次买入时的最大收益，sell[j] 表示在第j 次卖出时的最大收益。

buy的状态转移方程：buy[j] = max(buy[j], sell[j-1] - prices[i]); 买卖 j-1次的收益 - 今日买股票的消费

 sell的状态转移方程： sell[j] = max(sell[j], buy[j] + prices[i]); 买 j 次 + 今日卖股票的收益



## Java

```java
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        if (k > prices.length) {
            return helper(prices);
        }
        int[] buy = new int[k+1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        int[] sell = new int[k+1];
        for (int i=0; i<prices.length; i++) {
            for (int j=1; j<=k; j++) {
                buy[j] = Math.max(buy[j], sell[j-1]-prices[i]);
                sell[j] = Math.max(sell[j], buy[j]+prices[i]);
            }
        }
        return sell[k];
    }
    
    private int helper(int[] prices) {
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

