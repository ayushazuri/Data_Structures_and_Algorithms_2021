/*
* Given the heads of two singly linked-lists headA and headB,
* return the node at which the two lists intersect.
* If the two linked lists have no intersection at all, return null.
* https://leetcode.com/problems/intersection-of-two-linked-lists/
* */

public class Intersection {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int data){
            this.val = data;
            this.next = null;
        }
    }
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while(a != null || b != null){ // run till both of them are not null
            if(a == b)
                return a;

            a = a == null ? headB : a.next; //when a becomes null point it to headB
            b = b == null ? headA : b.next; //when b becomes null point it to headA

            // After a point they will eventually start from same point
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int lenA = length(headA), lenB = length(headB);
        // move headA and headB to the same start point
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }
        // find the intersection until end
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    private int length(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }
}
