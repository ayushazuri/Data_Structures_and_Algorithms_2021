/*
* Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.
* https://leetcode.com/problems/reverse-nodes-in-k-group/
* */

public class ReverseInKGroups {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int data){
            this.val = data;
            this.next = null;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy, curr = dummy, nex = dummy;

        int c = 0;
        while(curr.next != null){
            curr = curr.next;
            c++;
        }

        while(c >= k){
            curr = prev.next;
            nex = curr.next;
            for(int i = 1; i < k; i++){
                curr.next = nex.next;
                nex.next = prev.next;
                prev.next = nex;
                nex = curr.next;
            }
            prev = curr;
            c -= k;
        }

        return dummy.next;
    }
}
