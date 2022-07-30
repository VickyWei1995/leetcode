package LeetCode;

import java.util.Arrays;

public class BestTimeBuyandSellStockwithCooldown {
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
}
