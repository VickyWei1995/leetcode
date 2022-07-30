package LeetCode;

public class CountPrimes {
    public static void main(String[] args) {
        int test = 10;
        Solution s = new Solution();
        s.countPrimes(test);
    }

    static class Solution {
        public int countPrimes(int n) {
            int result = 0;
            for (int i=2; i<n;i++) {
                if (isPrime(i)) {
                    result++;
                }
            }
            return result;
        }

        private boolean isPrime(int n) {
            if (n==2) {
                return true;
            }
            int max = (int) Math.sqrt(n);
            for (int i=2; i<= max; i++) {
                if (n % i == 0) {
                    return true;
                }
            }
            return false;
        }
    }

    class Solution2 {
        public int countPrimes(int n) {
            int result = 0;
            boolean[] dp = new boolean[n];
            for (int i=2; i<n;i++) {
                if (dp[i]) {
                    continue;
                }
                result++;
                for (int j=2; j*i<n; j++) {
                    dp[i*j] = true;
                }
            }
            return result;
        }


    }
}
