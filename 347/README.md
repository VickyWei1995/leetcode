# 347 Top K Frequent Elements

https://leetcode.com/problems/top-k-frequent-elements/

## Description

Given an integer array `nums` and an integer `k`, return *the* `k` *most frequent elements*. You may return the answer in **any order**.

 

## **Example 1:**

```
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
```

## **Example 2:**

```
Input: nums = [1], k = 1
Output: [1]
```

 

## **Constraints:**

- `1 <= nums.length <= 105`
- `-104 <= nums[i] <= 104`
- `k` is in the range `[1, the number of unique elements in the array]`.
- It is **guaranteed** that the answer is **unique**.



## 思路

找到无序数组中出现频率最高的top k 元素数组。桶排序，先确定每个元素的出现频率；再确定最大的出现频次数为n；然后建立n个桶，每个桶里是出现key频次的数组；最后逆序遍历，确定top k

## Java

```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
            for (int i=0; i<nums.length; i++) {
                Integer key = nums[i];
                if (countMap.containsKey(key)) {
                    countMap.replace(key, countMap.get(key) + 1);
                } else {
                    countMap.put(key, 1);
                }
            }
            int max = 0;
            for (Integer key: countMap.keySet()) {
                max= max < countMap.get(key) ? countMap.get(key) : max;
            }
            HashMap<Integer, ArrayList<Integer>> valueSort = new HashMap<>();
            for (Integer key: countMap.keySet()) {
                int valueSortKey = countMap.get(key) - 1;
                if (valueSort.containsKey(valueSortKey)) {
                    valueSort.get(valueSortKey).add(key);
                } else {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(key);
                    valueSort.put(valueSortKey, temp);
                }
            }
            int[] result = new int[k];
            int resultIndex = 0;
            for (int i=max-1; i>=0 && resultIndex<k; i--) {
                if (valueSort.get(i) == null) {
                    continue;
                }
                for (int value: valueSort.get(i)) {
                    result[resultIndex++] = value;
                    if (resultIndex == k) {
                        break;
                    }
                }
            }
            return result;
    }
}
```

