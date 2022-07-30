package LeetCode;

public class BestTimeBuyandSellStock {
    public static void main(String[] args) {

    }

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

}
