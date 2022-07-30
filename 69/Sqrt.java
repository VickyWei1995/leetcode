package LeetCode;

public class Sqrt {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.mySqrt(2147395599);
    }

    static class Solution {
        public int mySqrt(int x) {
            if (x == 0) {
                return 0;
            }
            int left = 1, right = x;
            return findSqrtInRange(left, x, x);
        }

        private int findSqrtInRange(int left, int right, int target) {
            if (left >= right) {
                if (right > target/right) {
                    return right - 1;
                } else {
                    return right;
                }
            }
            int middle = left + (right - left) / 2;
            int sqrt = target/middle;
            if (sqrt == middle) {
                return middle;
            } else if (sqrt < middle) {
                return findSqrtInRange(left, middle -1, target);
            } else {
                return findSqrtInRange(middle+1, right, target);
            }
        }
    }

    class Solution2 {
        public int mySqrt(int x) {
            int l=0, r=x, target=x, sqrt;
            while (l<r) {
                int mid  = l + (r-l)/2;
                sqrt = x/mid;
                if (mid==sqrt) {
                    return mid;
                } else if (mid > sqrt) {
                    r = mid -1;
                } else {
                    l = mid;
                }
            }
            return l;
        }
    }
}
