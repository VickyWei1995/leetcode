package LeetCode;

public class CountingBits {
    class Solution {
        public int[] countBits(int n) {
            int[] results = new int[n+1];
            for (int i=0; i<=n; i++) {
                results[i] = countBitsHelper(i);
            }
            return results;
        }

        private int countBitsHelper(int n) {
            int res = 0;
            while(n>0) {
                if ((n&1) == 1) {
                    res+=1;
                }
                n >>=1;
            }
            return res;
        }
    }

    class Solution2 {
        public int[] countBits(int n) {
            int[] results = new int[n+1];
            for (int i=1; i<=n; i++) {
                results[i] = (i&1)==1 ? results[i-1]+1 : results[i>>1];
            }
            return results;
        }
    }
}
