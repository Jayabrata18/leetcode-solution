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
  return recursiveMerge(lists, 0, lists.length - 1);
    }

    private ListNode recursiveMerge(ListNode[] lists, int lo, int hi) {
        // nothing to do, simply return null
        if(lists == null || lists.length == 0) return null;
        // base case (list size 2 or size 1)
        if(hi - lo == 1) {
            // size 2 perform merge
            return merge(lists[lo], lists[hi]);
        }
        if(hi == lo) {
            // size 1 simply return the node
            return lists[hi];
        }
        int mid = (lo + hi) / 2;
        // recursive call
        ListNode left = recursiveMerge(lists, lo, mid);
        ListNode right = recursiveMerge(lists, mid + 1, hi);
        // return left and right merge
        return merge(left, right);
    }

    private ListNode merge(ListNode n1, ListNode n2) {
        // merge sort(merge two linkedList into one)
        if(n1 == null) return n2;
        if(n2 == null) return n1;
        ListNode temp1 = n1;
        ListNode temp2 = n2;
        ListNode curr = new ListNode(0);
        while(temp1 != null && temp2 != null) {
            if(temp1.val <= temp2.val) {
                curr.next = temp1;
                temp1 = temp1.next;
            } else {
                curr.next = temp2;
                temp2 = temp2.next;
            } 
            curr = curr.next;
        }
        if(temp1 != null) curr.next = temp1;
        if(temp2 != null) curr.next = temp2;
        return n1.val <= n2.val ? n1 : n2;
    }
}