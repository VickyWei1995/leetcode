# 435 Non-overlapping Intervals

## Description

Given an array of intervals `intervals` where `intervals[i] = [starti, endi]`, return *the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping*.

 

## **Example 1:**

```
Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
```

## **Example 2:**

```
Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
```

## **Example 3:**

```
Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
```

 

## **Constraints:**

- `1 <= intervals.length <= 105`
- `intervals[i].length == 2`
- `-5 * 104 <= starti < endi <= 5 * 104`

## 思路

先排序，然后根据贪心算法，先取结束值最小的；或者逆序排序，先取开始值最大的

## Java

```java
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        java.util.Arrays.sort(intervals, new java.util.Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[0] - o1[0];
                }
            });
            // 选取开头大，且不重叠的区间
            int beginInt = intervals[0][0];
            int result = 0;
            for (int i=1; i<intervals.length; i++) {
                if (intervals[i][1] <= beginInt) {
                    beginInt = intervals[i][0];
                } else {
                    result++;
                }
            }
            return result;
    }
}
```

