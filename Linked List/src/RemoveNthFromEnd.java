//Given the head of a linked list, remove the nth node from the end of the list and return its head.
//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthFromEnd {
    class ListNode{
        int data;
        ListNode next;
        ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args) {

    }
    public ListNode removeNthFromEnd1(ListNode head, int n) { //O(2n)
        ListNode temp = head;
         int len = 0;
         while(temp != null){
             len++;
             temp = temp.next;
         }


         n = len - n;
         if(n < 1)
             return head.next;

         temp = head;
         for(int i = 1;i<n;i++){
             temp = temp.next;
         }

         temp.next = temp.next.next;
         return head;
    }
    public ListNode removeNthFromEnd2(ListNode head, int n) { //O(n)
        ListNode fast = head;
        ListNode slow = null;
        for(int i = 1;i < n; i++){
            fast = fast.next;
        }
        if(fast.next == null)
            return head.next;

        while(fast.next != null){
            fast = fast.next;
            if(slow == null)
                slow = head;
            else
                slow = slow.next;
        }
        slow.next = slow.next.next;

        return head;

    }
}
