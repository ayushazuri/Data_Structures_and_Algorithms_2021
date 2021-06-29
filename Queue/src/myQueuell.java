public class myQueuell {
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    Node head, rear;
    public static void main(String[] args) {
        myQueuell queue = new myQueuell();
        queue.enqueue(11);
        queue.enqueue(22);
        queue.enqueue(33);
        queue.enqueue(44);
        queue.enqueue(55);

        queue.print();
        queue.dequeue();
        queue.print();
        queue.dequeue();
        queue.print();
    }

    public void enqueue(int data){
        Node toAdd = new Node(data);

        if(head == null){
            head = rear = toAdd;
        }else{
            rear.next = toAdd;
            rear = toAdd;
        }
    }

    public void dequeue(){
        if(head == null)
            return;
        System.out.println(head.data);
        head = head.next;
        if(head == null){
            rear = null;
        }
    }

    public int peek()throws Exception{
        if(head == null)
            throw new Exception("Stack is empty");

        return head.data;
    }
    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
