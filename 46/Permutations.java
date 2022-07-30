package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Solution s = new Solution();
        List<List<Integer>> res = s.permute2(nums);
        System.out.println(res.size());
    }

    static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums.length <= 1) {
                result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
                return result;
            }
            int[] subNums = Arrays.copyOf(nums, nums.length-1);
            int lastNum = nums[nums.length-1];
            List<List<Integer>> subResult = permute(subNums);
            for (List<Integer> resultList: subResult) {
                for (int i=0; i<=resultList.size(); i++) {
                    List<Integer> copy = new ArrayList<>(resultList);
                    copy.add(i, lastNum);
                    result.add(copy);
                }
            }
            return result;
        }
        public List<List<Integer>> permute2(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            permuteHelper(nums, res, 0);
            return res;
        }

        private void permuteHelper(int[] nums, List<List<Integer>> res, int start) {
            if (start >= nums.length) {
                res.add(Arrays.stream(nums)
                        .boxed()
                        .collect(Collectors.toList()));
                return;
            }
            for (int i=start; i<nums.length; i++) {
                swap(nums, start, i);
                permuteHelper(nums, res, start+1);
                swap(nums, i, start);
            }
        }

        private void swap(int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
            return;
        }
    }


}
