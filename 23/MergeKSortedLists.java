package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode l3 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l0 = new ListNode(5);
        l3.next = l2;
        l2.next = l0;
        l0.next = null;
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;
        l6.next = null;

        ListNode[] lists = new ListNode[2];
        lists[0] = l3;
        lists[1] = l4;


        Solution s = new Solution();
        s.mergeKLists(lists);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {
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
                queue.poll();
                temp = temp.next;
                if (temp.next != null) {
                    queue.add(temp.next);
                }
            }
            return head.next;
        }
    }
}
