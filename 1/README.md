# 1 Two Sum

https://leetcode.com/problems/two-sum/



## 思路

给定一个整数数组，已知有且只有两个数的和等于给定值，求这两个数的位置。 遍历数组，如果 nums[i] 在哈希表中存在，说明已经有符合条件的情况，即 i 和 nums[i] 对应的value。否则更新哈希表，key = target - nums[i]， value = i。

## Java

```java
class Solution {
    // hashmap
    public int[] twoSum(int[] nums, int target) {
        if (nums.length <= 1) {
            return null;
        }
        int[] result = {-1,-1};
        HashMap<Integer,Integer> m1=new HashMap<Integer,Integer>();  
        for (int i=0; i<nums.length; i++) {
            int sub = target - nums[i];
            if (m1.containsKey(nums[i])) {
                return new int[] {i, m1.get(nums[i])};
            }
            m1.put(sub, i);
        }
        return result;
    }
}
```

