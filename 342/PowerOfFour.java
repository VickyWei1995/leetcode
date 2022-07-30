package LeetCode;

public class PowerOfFour {
    class Solution {
        public boolean isPowerOfFour(int n) {
            int index = 1;
            int count = 0;
            while(n>0) {
                if((n & 1) == 0) {
                    index++;
                } else {
                    count++;
                }
                n >>= 1;
            }
            return index %2 == 1 && count == 1;
        }
    }
}
