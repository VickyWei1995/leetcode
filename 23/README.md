# 23 Merge k Sorted Lists

https://leetcode.com/problems/merge-k-sorted-lists/



## 思路

给定k 个增序的链表，试将它们合并成一条增序链表。

解法一：类似于归并排序进行两两合并。

解法二：把所有的链表存储在一个优先队列中，设置 Comparator 实现最小堆。每次取优先队列的peek元素，并且把peek的next加入队列

## Java

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
            Comparator<ListNode> comparator = new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return (o1.val - o2.val);
                }
            };
            Queue<ListNode> queue = new PriorityQueue<ListNode>(comparator);
            for (ListNode n: lists) {
                if (n!=null) {
                    queue.add(n);
                }
            }
            ListNode head = new ListNode(-1);
            ListNode temp = head;
            while(!queue.isEmpty()) {
                temp.next = queue.peek();
                queue.remove();
                temp = temp.next;
                if (temp.next != null) {
                    queue.add(temp.next);
                }
            }
            return head.next;
        
    }
    
}
```

