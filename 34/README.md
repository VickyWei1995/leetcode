# 34 Find First and Last Position of Element in Sorted Array

https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

## Description

Given an array of integers `nums` sorted in non-decreasing order, find the starting and ending position of a given `target` value.

If `target` is not found in the array, return `[-1, -1]`.

You must write an algorithm with `O(log n)` runtime complexity.

 

## **Example 1:**

```
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
```

## **Example 2:**

```
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
```

## **Example 3:**

```
Input: nums = [], target = 0
Output: [-1,-1]
```

 

## **Constraints:**

- `0 <= nums.length <= 105`
- `-109 <= nums[i] <= 109`
- `nums` is a non-decreasing array.
- `-109 <= target <= 109`



## 思路

分为2次查找，第一次查找first position；第二次查找last position

## Java

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
            if (nums.length == 0) {
                return result;
            }
            result[0] = lower_bound(nums, target);
            result[1] = upper_bound(nums, target);
            return result;
    }
    
    private int lower_bound(int[] nums, int target) {
            int l=0, r=nums.length-1;
            while (l<= r) {
                int mid = l + (r-l)/2;
                if (nums[mid] == target) {
                    if (mid == 0 ||  nums[mid-1] < target) {
                        return mid;
                    } else {
                        r = mid -1;
                    }
                } else if (nums[mid] < target) {
                    l = mid +1;
                } else {
                    r = mid -1;
                }
            }
            if (r>=0 && r<nums.length && nums[r] == target) {
                return r;
            }
            return -1;
        }

        private int upper_bound(int[] nums, int target) {
            int l=0, r=nums.length-1;
            while (l<= r) {
                int mid = l + (r-l)/2;
                if (nums[mid] == target) {
                    if (mid == nums.length-1 || nums[mid+1] > target) {
                        return mid;
                    } else {
                        l = mid +1;
                    }
                } else if (nums[mid] < target) {
                    l = mid +1;
                } else {
                    r = mid -1;
                }
            }
            if (r>=0 && r<nums.length &&  nums[r] == target) {
                return r;
            }
            return -1;
        }
}
```

