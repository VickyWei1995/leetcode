package LeetCode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] test = {100, 4, 200, 1, 3, 2};
        Solution s = new Solution();
        s.longestConsecutive(test);
    }

    static class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            int result = 0;
            for (int cur : nums) {
                if (set.remove(cur)) {
                    int last = cur - 1, next = cur + 1;
                    while (set.remove(last)) {
                        last--;
                    }
                    while (set.remove(next)) {
                        next++;
                    }
                    result = Math.max(result, next-last-1);
                }
            }
            return result;
        }
    }

}
