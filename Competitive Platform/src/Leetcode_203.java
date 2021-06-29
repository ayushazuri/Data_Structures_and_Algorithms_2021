//https://leetcode.com/problems/remove-linked-list-elements/

public class Leetcode_203 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
    public static void main(String[] args) {

    }
        public ListNode removeElements(ListNode head, int val) {
            if (head == null)
                return head;

            ListNode temp = head.next, prev = head;
            while (temp != null) {
                if (temp.val == val) {
                    prev.next = temp.next;
                    temp = prev.next;
                } else {
                    temp = temp.next;
                    prev = prev.next;
                }
            }

            if (head.val == val)
                head = head.next;

            return head;
        }
}
