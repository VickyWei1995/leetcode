package LeetCode;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {

    }

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
}
