package LeetCode;

public class ClimbingStairs {
    public static void main(String[] args) {

    }

    class Solution {
        public int climbStairs(int n) {
            if (n==1) {
                return 1;
            }
            if (n==2) {
                return 2;
            }
            int[] results = new int[n];
            results[0] = 1;
            results[1] = 2;
            return helper(results, n);
        }

        private int helper(int[] results, int n) {
            if (results[n-1] > 0) {
                return results[n-1];
            }
            results[n-1] = helper(results, n-1) + helper(results, n-2);
            return results[n-1];
        }
    }
}
