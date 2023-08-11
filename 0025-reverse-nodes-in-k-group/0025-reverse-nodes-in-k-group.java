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
//     if(k<=1 || head == null) {}
//     ListNode current = head;
//     ListNode prev = null;

//     while(true){
//         ListNode last = prev;
//         ListNode newEnd = current;
//         //reverse between k

//         ListNode next = current.next;
//         for(int i = 0; current != null && i<k; i++){
//             current.next = prev;
//             prev = current;
//             current = next;
//             if(next != null ){
//                 next = next.next;
//             }
//         }
//         if(last != null){
//             last.next = prev;
        
//         }else{
//             head = prev;
//         }
//         newEnd.next = current;
//         if(current ==null){
//             break;
//         }
//         prev = newEnd;
//     }    
//     return head;
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

    ListNode curr = head;
    int count = 0;
    while(curr != null && count != k){
        curr = curr.next;
        count++;
    }
    if(count == k ){
        curr = reverseKGroup(curr,k);
        while(count -- >0){
            ListNode temp = head.next;
            head.next = curr;
            curr = head;
            head = temp;
        }
        head =curr;
    }
    return head;
}
}