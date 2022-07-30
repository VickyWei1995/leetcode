package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] test = {1,3,1,2,0,5};
        int k =3;
        Solution s = new Solution();
        s.maxSlidingWindow(test, k);
    }
    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            Deque<Integer> q = new LinkedList<>();
            int[] res = new int[nums.length-k+1];
            for (int i=0; i<nums.length; i++) {
                if (!q.isEmpty() && q.peekFirst() == i - k) {
                    q.pollFirst();
                }
                while(!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                    q.pollLast();
                }
                q.offerLast(i);
                if (i>= k-1) {
                    res[i-k+1] = nums[q.peekFirst()];
                }
            }
            return res;
        }
    }
}
