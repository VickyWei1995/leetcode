package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInArray {
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            int[] temp = new int[nums.length];
            List<Integer> result = new ArrayList<>();
            for (int num: nums) {
                temp[num-1] = 1;
            }
            for (int i=0; i<temp.length; i++) {
                if (temp[i] != 1) {
                    result.add(i+1);
                }
            }
            return result;
        }
    }
}
