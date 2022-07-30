# 142 Linked List Cycle II

https://leetcode.com/problems/linked-list-cycle-ii/

## Description

Given the `head` of a linked list, return *the node where the cycle begins. If there is no cycle, return* `null`.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the `next` pointer. Internally, `pos` is used to denote the index of the node that tail's `next` pointer is connected to (**0-indexed**). It is `-1` if there is no cycle. **Note that** `pos` **is not passed as a parameter**.

**Do not modify** the linked list.

 

## **Example 1:**

![circularlinkedlist](./circularlinkedlist.png)

```
Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.
```

## **Example 2:**

![circularlinkedlist_test2](./circularlinkedlist_test2.png)

```
Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.
```

## Example 3:

![circularlinkedlist_test3](./circularlinkedlist_test3.png)

```
Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.
```



## **Constraints:**

- The number of the nodes in the list is in the range `[0, 104]`.
- `-105 <= Node.val <= 105`
- `pos` is `-1` or a **valid index** in the linked-list.



## 思路

找出环路的起始点。快慢指针，快指针一次走2个节点，慢指针一次走1个节点，如果相遇，说明有环；相遇后，将慢指针移到header处，2个指针一起走，每次走一个节点，再相遇的时候会在环的起始点

## Java

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
            ListNode fast = head;
            while (fast != null && slow != null) {
  
                slow = slow.next;
                fast = fast.next;
                if (fast != null) {
                    fast = fast.next;
                }
                if (fast == slow) {
                    break;
                }
            }
            if (fast == null || slow == null) {
                return null;
            }
            slow = head;
            while(true) {
                if (slow == fast) {
                    break;
                }
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
    }
}
```

