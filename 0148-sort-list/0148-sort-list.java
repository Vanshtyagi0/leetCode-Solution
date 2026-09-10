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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode right = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        right = sortList(right);

        return merge(left, right);
    }

    private ListNode merge(ListNode a, ListNode b){

        ListNode Head = new ListNode();
        ListNode curr = Head;

        while(a != null && b != null){
            if(a.val < b.val){
                curr.next = a;
                a = a.next;
            }
            else{
                curr.next = b;
                b = b.next;
            }
            
            curr = curr.next;
        }

        curr.next = (a != null) ? a : b;

        return Head.next;
    }
}