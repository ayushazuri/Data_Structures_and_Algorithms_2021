/*
    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit.
    Add the two numbers and return the sum as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    https://leetcode.com/problems/add-two-numbers/
*/
public class AddTwoNumbersInLinkedListForm {
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode d = new ListNode(0);
        ListNode temp = d;
        int sum = 0, c = 0;

        while(l1 != null || l2 != null || c == 1){
            sum = 0;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            sum += c;

            temp.next = new ListNode(sum%10);
            c = sum/10;
            temp = temp.next;
        }
        return d.next;
    }
}
