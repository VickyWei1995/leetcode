public class LinkedListCycleII {
    public static void main(String[] args) {
        ListNode l3 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l0 = new ListNode(0);
        ListNode l4 = new ListNode(-4);
        l3.next = l2;
        l2.next = l0;
        l0.next = l4;
        l4.next = l2;
        Solution s = new Solution();
        s.detectCycle(l3);
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

}
