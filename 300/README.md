# 300 Longest Increasing Subsequence

https://leetcode.com/problems/longest-increasing-subsequence/



## 思路

在本题中，dp[i] 可以表示以i 结尾的、最长子序列长度。对于每一个位置i，如果其之前的某个位置j 所对应的数字小于位置i 所对应的数字，则我们可以获得一个以i 结尾的、长度为dp[j]+ 1 的子序列。为了遍历所有情况，我们需要i 和j 进行两层循环，其时间复杂度为O(n^2)



本题还可以使用二分查找将时间复杂度降低为O.n log n.。我们定义一个dp 数组，其中dp[k]存储长度为k+1 的最长递增子序列的最后一个数字。我们遍历每一个位置i，如果其对应的数字大于dp 数组中所有数字的值，那么我们把它放在dp 数组尾部，表示最长递增子序列长度加1；如果我们发现这个数字在dp 数组中比数字a 大、比数字b 小，则我们将b 更新为此数字，使得之后构成递增序列的可能性增大。以这种方式维护的dp 数组永远是递增的，因此可以用二分查找加速搜索。

## Java

```java
class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> dp = new ArrayList<>();
            dp.add(nums[0]);
            for(int i=1; i<nums.length;i++) {
                if (nums[i] < dp.get(0)) {
                    dp.set(0, nums[i]);
                } else if (nums[i] > dp.get(dp.size() - 1)) {
                    dp.add(nums[i]);
                } else {
                    int tempIndex = findMaxThan(nums[i], dp);
                    dp.set(tempIndex, nums[i]);
                }
            }
            return dp.size();
    }
    
    private int findMaxThan(int num, List<Integer> dp) {
        int left =0, right=dp.size()-1;
        int mid;
        while(left<right) {
            mid = left + (right-left)/2;
            if (dp.get(mid) == num) {
                return mid;
            }
            if (dp.get(mid) < num) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
```

