package LeetCode;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            if (sum % 2 == 1) {
                return false;
            }
            int halfSum = sum/2;
            boolean[] dp = new boolean[halfSum+1];
            dp[0] = true;
            for (int i=0; i<nums.length; i++) {
                int w = nums[i];
                for (int j=halfSum; j>=w; j--) {
                    dp[j] = dp[j] || dp[j-w];
                }
            }
            return dp[halfSum];
        }
    }
}
