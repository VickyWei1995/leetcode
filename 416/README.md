# 416 Partition Equal Subset Sum

https://leetcode.com/problems/partition-equal-subset-sum/



## 思路

给定一个正整数数组，求是否可以把这个数组分成和相等的两部分。 

这个可以看做一个背包问题，对于数组中的元素进行选择，使其和为halfSum。halfSum=sum(数组)/2。设置一个dp数组，里面保存的为boolean。状态转移方程为：dp[j] = dp[j] || dp[j-w]

## Java

```java
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        int halfSum = sum/2;
        boolean[] dp = new boolean[halfSum+1];
        dp[0] = true;
        for (int i=0; i<nums.length; i++) {
            int w = nums[i];
            for (int j=halfSum; j>=w; j--) {
                dp[j] = dp[j] || dp[j-w];
            }
        }
        return dp[halfSum];
    }
}
```

