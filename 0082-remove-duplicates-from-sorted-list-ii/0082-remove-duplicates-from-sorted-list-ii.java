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
    public ListNode deleteDuplicates(ListNode head) {
        if(head== null || head.next == null) return head;

        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode cur = fake;

        while(cur.next != null  && cur.next.next != null){
            if(cur.next.val == cur.next.next.val){
            //check again
            int duplicate = cur.next.val;
            while (cur.next != null && cur.next.val == duplicate){

            cur.next = cur.next.next;
            }
            }else{
        cur = cur.next;
        }
        }
        
        return fake.next;
    }
    
}