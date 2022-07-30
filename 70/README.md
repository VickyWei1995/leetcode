# 70 Climbing Stairs

https://leetcode.com/problems/climbing-stairs/



## 思路

给定n 节台阶，每次可以走一步或走两步，求一共有多少种方式可以走完这些台阶。result[n] = result[n-1] + result[n-2]

## Java

```java
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
```

