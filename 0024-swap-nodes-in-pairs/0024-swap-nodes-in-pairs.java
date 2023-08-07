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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // Create a new node "pointer" and set its next to the head of the list.
        ListNode pointer = new ListNode();
        pointer.next = head;

        // Create a new ListNode "res" to store the new head after swapping.
        ListNode res = head.next;

        // Iterate through the linked list in pairs.
        while (pointer.next != null && pointer.next.next != null) {
            ListNode first = pointer.next;         // First node of the current pair.
            ListNode second = pointer.next.next;   // Second node of the current pair.
            ListNode tail = second.next;           // Node after the second node.

            // Swap the nodes.
            pointer.next = second;     // Update the previous node to point to the second node.
            second.next = first;       // Connect the second node to the first node.
            first.next = tail;         // Connect the first node to the node after the second.

            // Move the pointer two nodes forward.
            pointer = pointer.next.next;

            // Break the loop if there are less than two nodes left to swap.
            if (pointer == null || pointer.next == null)
                break;
        }

        // Return the new head of the swapped linked list.
        return res;
    }
}
