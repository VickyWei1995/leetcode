# 215 Kth Largest Element in an Array

https://leetcode.com/problems/kth-largest-element-in-an-array/

## Description

Given an integer array `nums` and an integer `k`, return *the* `kth` *largest element in the array*.

Note that it is the `kth` largest element in the sorted order, not the `kth` distinct element.

You must solve it in `O(n)` time complexity.

 

## **Example 1:**

```
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
```

## **Example 2:**

```
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
```

 

## **Constraints:**

- `1 <= k <= nums.length <= 105`
- `-104 <= nums[i] <= 104`



## 思路

找到无序数组中第k大的元素。快排的思想去做。如果pivot是第k大，则直接返回，不需要继续排序；如果pivot 大于第k，更新right=pivotIndex-1；如果pivot 小于第k，更新left=pivotIndex+1

## Java

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int left=0, right=nums.length-1;
            int kIndex = nums.length - k;

            while (left < right) {
                int pivotIndex = partion(nums, left, right);
                if (pivotIndex == kIndex ) {
                    return nums[pivotIndex];
                } else if (pivotIndex > kIndex) {
                    right = pivotIndex - 1;
                } else {
                    left = pivotIndex + 1;
                }
            }
            return nums[left];
    }
    
    private int partion(int[] nums, int left, int right) {
            int pivot = nums[left];
            int pivotIndex = left+1;
            for (int i=left+1; i<=right; i++) {
                if (nums[i] < pivot) {
                    int temp = nums[i];
                    nums[i] = nums[pivotIndex];
                    nums[pivotIndex] = temp;
                    pivotIndex++;
                }
            }
            nums[left] = nums[pivotIndex-1];
            nums[pivotIndex-1] = pivot;
            return pivotIndex-1;
        }
}
```

