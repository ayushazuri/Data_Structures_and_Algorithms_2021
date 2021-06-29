public class myLinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    Node head;
    public static void main(String[] args) {
        myLinkedList ll = new myLinkedList();
        ll.addEnd(11);
        ll.addFront(22);
        ll.addFront(33);
        ll.addEnd(44);
        ll.addBetween(55, 2);
        ll.addEnd(66);

        ll.print();
        ll.deleteFront();
        ll.print();
        ll.deleteEnd();
        ll.print();
        ll.deleteBetween(1);
        ll.print();
    }

    public void addEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    public void addBetween(int data, int loc){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node temp = head;

        for(int i = 0;i < loc - 1;i++){
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void addFront(int data){
        Node newNode = new Node(data);
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
    }

    public void deleteFront(){
        if(head == null) return;

        Node temp = head;
        head = temp.next;
        temp.next = null;
    }

    public void deleteEnd(){
        if(head == null) return;

        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
    }
    public void deleteBetween(int loc){ //loc is wrt to 1
        if(head == null) return;

        Node temp = head;
        for(int i=0;i<loc-2;i++){
            temp = temp.next;
        }
        Node x = temp.next;
        temp.next = temp.next.next;
        x.next = null;
    }

    public void print(){
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

}
