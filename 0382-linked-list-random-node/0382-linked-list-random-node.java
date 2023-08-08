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
    ListNode temp;
    Random random;
    public Solution(ListNode head) {
        temp=head;
        random=new Random();
    }
    
    public int getRandom() {
        int count=0;
        int res=0;
        ListNode cur=temp;
        while(cur!=null)
        {
            count++;
            if(random.nextInt(count)==0){
                res=cur.val;
            }
            cur=cur.next;
        }
        return res;
        
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */