# 239 Sliding Window Maximum

https://leetcode.com/problems/sliding-window-maximum/



## 思路

给定一个整数数组和一个滑动窗口大小，求在这个窗口的滑动过程中，每个时刻其包含的最大值。我们可以利用双端队列进行操作：每当向右移动时，把窗口左端的值从队列左端剔除，把队列右边小于窗口右端的值全部剔除。这样双端队列的最左端永远是当前窗口内的最大值。该双端队列利用从左到右递减来维持大小关系。

队列中需要保存index，通过index确定队列左端的元素是否需要被剔除

## Java

```java
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
            int[] res = new int[nums.length-k+1];
            for (int i=0; i<nums.length; i++) {
                if (!q.isEmpty() && q.peekFirst() == i - k) {
                    q.pollFirst();
                }
                while(!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                    q.pollLast();
                }
                q.offerLast(i);
                if (i>= k-1) {
                    res[i-k+1] = nums[q.peekFirst()];
                }
            }
            return res;
    }
}
```

