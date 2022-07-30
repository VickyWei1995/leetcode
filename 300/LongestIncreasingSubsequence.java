package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] test = {10,9,2,5,3,7,101,18};
        Solution2 s = new Solution2();
        s.lengthOfLIS(test);

    }

    class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            int result = 0;
            for(int i=0;i<nums.length; i++) {
                dp[i] = 1;
                for(int j=0; j<i; j++) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[i], dp[j]+1);
                    }
                }
                result = Math.max(result, dp[i]);
            }
            return result;
        }
    }

    static class Solution2 {
        public int lengthOfLIS(int[] nums) {
            List<Integer> dp = new ArrayList<>();
            dp.add(nums[0]);
            for(int i=1; i<nums.length;i++) {
                if (nums[i] < dp.get(0)) {
                    dp.set(0, nums[i]);
                } else if (nums[i] > dp.get(dp.size() - 1)) {
                    dp.add(nums[i]);
                } else {
                    int tempIndex = findMaxThan(nums[i], dp);
                    dp.set(tempIndex, nums[i]);
                }
            }
            return dp.size();
        }

        private int findMaxThan(int num, List<Integer> dp) {
            int left =0, right=dp.size()-1;
            int mid;
            while(left<right) {
                mid = left + (right-left)/2;
                if (dp.get(mid) == num) {
                    return mid;
                }
                if (dp.get(mid) < num) {
                    left = mid+1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }
}
