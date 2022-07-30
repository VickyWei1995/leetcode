package LeetCode;

public class BestTimeBuyandSellStockII {
    public static void main(String[] args) {

    }
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
}
