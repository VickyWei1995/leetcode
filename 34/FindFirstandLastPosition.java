package LeetCode;

import java.util.Arrays;

public class FindFirstandLastPosition {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = {1};
        int[] result = s.searchRange(test, 0);
        System.out.print(Arrays.toString(result));
    }

    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] result = {-1, -1};
            if (nums.length == 0) {
                return result;
            }
            result[0] = lower_bound(nums, target);
            result[1] = upper_bound(nums, target);
            return result;
        }

        private int lower_bound(int[] nums, int target) {
            int l=0, r=nums.length-1;
            while (l<= r) {
                int mid = l + (r-l)/2;
                if (nums[mid] == target) {
                    if (mid == 0 ||  nums[mid-1] < target) {
                        return mid;
                    } else {
                        r = mid -1;
                    }
                } else if (nums[mid] < target) {
                    l = mid +1;
                } else {
                    r = mid -1;
                }
            }
            if (r>=0 && r<nums.length && nums[r] == target) {
                return r;
            }
            return -1;
        }

        private int upper_bound(int[] nums, int target) {
            int l=0, r=nums.length-1;
            while (l<= r) {
                int mid = l + (r-l)/2;
                if (nums[mid] == target) {
                    if (mid == nums.length-1 || nums[mid+1] > target) {
                        return mid;
                    } else {
                        l = mid +1;
                    }
                } else if (nums[mid] < target) {
                    l = mid +1;
                } else {
                    r = mid -1;
                }
            }
            if (r>=0 && r<nums.length &&  nums[r] == target) {
                return r;
            }
            return -1;
        }
    }
}
