/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Node curr = head;
        // Phase1: 1 -> 1' -> 2 -> 2' -> null
        while(curr != null){
            Node copy = new Node(curr.val);

            copy.next = curr.next;
            curr.next = copy;

            curr = copy.next;
        }

        curr = head;
        // Phase2: copy the random pointer 1'.random = 1.random.next;
        while(curr != null){
            Node copy = curr.next;

            if(curr.random != null){
                copy.random = curr.random.next;
            }

            curr = copy.next;
        }
        curr = head;
        Node copyHead = curr.next;

        // Phase3: break the orginal and copy list
        while(curr != null){
            Node copy = curr.next;

            curr.next = copy.next;
            if(copy.next != null){
                copy.next = copy.next.next;
            }

            curr = curr.next;
        }

        return copyHead;
    }
}