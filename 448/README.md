# 448 Find All Numbers Disappeared in an Array

https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/



## 思路

给定一个长度为n 的数组，其中包含范围为1 到n 的整数，有些整数重复了多次，有些整数没有出现，求1 到n 中没有出现过的整数。复杂度 O(n)，空间复杂度 O(1)。 遍历数组，对数组中的元素取负；再次遍历，仍为正数的index是没有出现过的整数

## Java

```java
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int num:nums) {
            int pos = Math.abs(num) -1;
            if (nums[pos] > 0) {
                nums[pos] = -nums[pos];
            }
        }
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i+1);
            }
        }
        return result;
    }
}
```

