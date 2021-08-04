/*
* Given the head of a singly linked list, return true if it is a palindrome.
* https://leetcode.com/problems/palindrome-linked-list/
*/


public class DetectPalindrome {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int data){
            this.val = data;
            this.next = null;
        }
    }
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = reverseList(slow.next);
        slow = slow.next;
        fast = head;

        while(slow != null){
            if(slow.val != fast.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head){
        ListNode prev = null, curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
