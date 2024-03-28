public class Solution {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode removeZeroSumSublists(ListNode head) {

        ListNode dummy = new ListNode(0, head);

        Map<Integer, ListNode> cumulativeSum = new HashMap<>();
        int sum = 0;

        ListNode current = dummy;

        while (current != null) {
            sum += current.val;
            cumulativeSum.put(sum, current);
            current = current.next;
        }
        sum = 0;
        current = dummy;

        while (current != null) {
            sum += current.val;

            current.next = cumulativeSum.get(sum).next;
            current = current.next;
        }

        return dummy.next;
    }
}