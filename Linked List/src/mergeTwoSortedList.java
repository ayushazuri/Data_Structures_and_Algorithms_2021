public class mergeTwoSortedList {
   static class ListNode {
        int val;
        ListNode next;
        ListNode(int data){
            this.val = data;
            next = null;
        }
    }

    public static ListNode insert(ListNode head, int data ){
        ListNode toAdd = new ListNode(data);
        if(head == null){
            return toAdd;
        }else{
            ListNode temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = toAdd;
        }
        return head;
    }
    public static void print(ListNode head){
       ListNode temp = head;
       while(temp != null){
           System.out.print(temp.val + " ");
           temp = temp.next;
       }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode l1 = null;
        l1 = insert(l1,5);
        l1 = insert(l1, 7);
        l1 = insert(l1, 9);

        ListNode l2 = null;
        l2 = insert(l2, 3);
        l2 = insert(l2, 4);
        l2 = insert(l2, 8);
        l2 = insert(l2, 10);

        print(l1);
        print(l2);

        ListNode res;
        res = iterative(l1, l2);
        print(res);
        res = recursiveMerge(l1, l2);
        print(res);
    }

    public static ListNode iterative(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val > l2.val){
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        ListNode res = l1;

        while(l1 != null && l2 != null){
            ListNode temp = null;
            while(l1 != null && l1.val <= l2.val){
                temp = l1;
                l1 = l1.next;
            }
            temp.next = l2;

            ListNode t = l1;
            l1 = l2;
            l2 = t;
        }

        return res;
    }

    public static ListNode recursiveMerge(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val < l2.val){
            l1.next = recursiveMerge(l1.next, l2);
            return l1;
        }
        l2.next = recursiveMerge(l1, l2.next);
        return l2;
    }
}
