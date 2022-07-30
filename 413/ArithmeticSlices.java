package LeetCode;

import java.util.ArrayList;

public class ArithmeticSlices {
    public static void main(String[] args) {

    }

    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            if (nums.length <=2) {
                return 0;
            }
            // 初始化
            int interval=nums[1]-nums[0], lens=2;
            ArrayList<Integer> lensList = new ArrayList<>();
            // 查找连续的等差数列，保存其长度
            for (int i=2; i<nums.length;i++) {
                int tempInterval = nums[i] - nums[i-1];
                if (tempInterval == interval) {
                    lens += 1;
                } else {
                    interval = tempInterval;
                    lensList.add(lens);
                    lens = 2;
                }
            }
            lensList.add(lens);
            // 遍历
            int result=0;
            for (int tempLens: lensList) {
                if (tempLens>2) {
                    result += (tempLens-1)*(tempLens-2)/2;
                }
            }
            return result;
        }
    }
}
