# 198 House Robber

https://leetcode.com/problems/house-robber/



## 思路

假如你是一个劫匪，并且决定抢劫一条街上的房子，每个房子内的钱财数量各不相同。如果你抢了两栋相邻的房子，则会触发警报机关。求在不触发机关的情况下最多可以抢劫多少钱。 dp[i] = max(dp[i-1], nums[i-1] + dp[i-2])。

## Java

```java
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
                return nums[0];
            }
            int one = nums[0];
            int two = Math.max(nums[0], nums[1]);
            for (int i=2; i<nums.length;i++) {
                int current = Math.max(one+nums[i], two);
                one = two;
                two = current;
            }
            return two;
    }
}
```

