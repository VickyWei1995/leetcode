# 204 Count Primes

https://leetcode.com/problems/count-primes/



## 思路

给定一个数字n，求小于n 的质数的个数。 埃拉托斯特尼筛法 Sieve of Eratosthenes ，我们从2开始遍历到根号n，先找到第一个质数2，然后将其所有的倍数全部标记出来，然后到下一个质数3，标记其所有倍数，一次类推，直到根号n，此时数组中未被标记的数字就是质数。



## Java

```java
class Solution {
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
```

