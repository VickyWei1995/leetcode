package LeetCode;

public class HouseRobber {
    public static void main(String[] args) {

    }

    class Solution {
        public int rob(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            int one = nums[0];
            int two = Math.max(nums[0], nums[1]);
            for (int i=2; i<nums.length;i++) {
                int current = Math.max(one+nums[i], two);
                one = two;
                two = current;
            }
            return two;
        }
    }
}
