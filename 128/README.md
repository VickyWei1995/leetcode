# 128 Longest Consecutive Sequence

https://leetcode.com/problems/longest-consecutive-sequence/



## 思路

给定一个整数数组，求这个数组中的数字可以组成的最长连续序列有多长。 设置一个set，里面存放了数组中的所有数字。针对set中的元素，遍历删除其last和next；直到set为空。

## Java

```java
class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> s = new HashSet<Integer>();
        for (int num : nums) s.add(num);
        for (int num : nums) {
            if (s.remove(num)) {
                int pre = num - 1, next = num + 1;
                while (s.remove(pre)) --pre;
                while (s.remove(next)) ++next;
                res = Math.max(res, next - pre - 1);
            }
        }
        return res;
    }
}
```

