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
    public ListNode partition(ListNode head, int x) {
        
        ListNode l1 = new ListNode(-1);
        ListNode l2 = new ListNode(-1);
        ListNode curr = head;
        ListNode pointer1 = l1;
        ListNode pointer2 = l2;
        while(curr != null){

            if(curr.val < x){
                pointer1.next = curr;
                pointer1 = pointer1.next;
            }
            else{
                pointer2.next = curr;
                pointer2 = pointer2.next;
            }

            curr = curr.next;
        }
        pointer1.next = l2.next;
        pointer2.next = null;
        head = l1.next;
        return head;
    }
}