# 769 Max Chunks To Make Sorted

https://leetcode.com/problems/max-chunks-to-make-sorted/submissions/



## 思路

给定一个含有0 到n 整数的数组，每个整数只出现一次，求这个数组最多可以分割成多少个子数组，使得对每个子数组进行增序排序后，原数组也是增序的。

因为数组只包含不重复的0 到n，所以截止到 i 位置的最大值一定不会小于 i。从左往右遍历，同时记录当前的最大值，每当当前最大值等于数组位置时，我们可以多一次分割。



## Java

```java
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max = 0;
        int res = 0;
        for (int i=0; i<arr.length;i++) {
            max = Math.max(arr[i], max);
            if (max == i) {
                res++;
            }
        }
        return res;
    }
}
```

