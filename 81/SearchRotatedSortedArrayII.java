package LeetCode;

import sun.lwawt.macosx.CSystemTray;

public class SearchRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1};
        int targe = 13;
        Solution s = new Solution();
        System.out.println( s.search(nums, targe) );
    }

    static class Solution {
        public boolean search(int[] nums, int target) {
            int left = 0, right = nums.length -1;
            while (left <= right) {
                int mid = left + (right-left)/2;
                if (nums[mid] == target) {
                    return true;
                }
                if (nums[mid] == nums[left]) {
                    left += 1;
                } else if (nums[mid] <= nums[right]) {
                    if (nums[mid] < target && nums[right] >= target) {
                        left = mid + 1;
                    } else {
                        right = mid -1;
                    }
                } else {
                    if (nums[mid] > target && nums[left] <= target) {
                        right = mid -1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
            return false;
        }
    }
}
