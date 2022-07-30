package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

public class TopKFrequentEles {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        Solution s = new Solution();
        s.topKFrequent(nums, k);
    }

    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> countMap = new HashMap<>();
            for (int i=0; i<nums.length; i++) {
                Integer key = nums[i];
                if (countMap.containsKey(key)) {
                    countMap.replace(key, countMap.get(key) + 1);
                } else {
                    countMap.put(key, 1);
                }
            }
            int max = 0;
            for (Integer key: countMap.keySet()) {
                max= max < countMap.get(key) ? countMap.get(key) : max;
            }
            HashMap<Integer, ArrayList<Integer>> valueSort = new HashMap<>();
            for (Integer key: countMap.keySet()) {
                int valueSortKey = countMap.get(key) - 1;
                if (valueSort.containsKey(valueSortKey)) {
                    valueSort.get(valueSortKey).add(key);
                } else {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(key);
                    valueSort.put(valueSortKey, temp);
                }
            }
            int[] result = new int[k];
            int resultIndex = 0;
            for (int i=max-1; i>=0 && resultIndex<k; i--) {
                if (valueSort.get(i) == null) {
                    continue;
                }
                for (int value: valueSort.get(i)) {
                    result[resultIndex++] = value;
                    if (resultIndex == k) {
                        break;
                    }
                }
            }
            return result;
        }
    }
}
