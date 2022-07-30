package LeetCode;

public class KthLargestEleInArray {
    public static void main(String[] args) {
        int[] test = {5,2,4,1,3,6,0};
        int k =4;
        Solution s = new Solution();
        s.findKthLargest(test, k);
    }

    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            int left=0, right=nums.length-1;
            int kIndex = nums.length - k;

            while (left < right) {
                int pivotIndex = partion(nums, left, right);
                if (pivotIndex == kIndex ) {
                    return nums[pivotIndex];
                } else if (pivotIndex > kIndex) {
                    right = pivotIndex - 1;
                } else {
                    left = pivotIndex + 1;
                }
            }
            return nums[left];
        }

        private int partion(int[] nums, int left, int right) {
            int pivot = nums[left];
            int pivotIndex = left+1;
            for (int i=left+1; i<=right; i++) {
                if (nums[i] < pivot) {
                    int temp = nums[i];
                    nums[i] = nums[pivotIndex];
                    nums[pivotIndex] = temp;
                    pivotIndex++;
                }
            }
            nums[left] = nums[pivotIndex-1];
            nums[pivotIndex-1] = pivot;
            return pivotIndex-1;
        }
    }
}
