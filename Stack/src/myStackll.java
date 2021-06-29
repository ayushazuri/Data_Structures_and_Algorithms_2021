public class myStackll {
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    Node top;

    public static void main(String[] args) {
        myStackll stack = new myStackll();
        stack.push(11);
        stack.push(22);
        stack.push(33);
        stack.push(44);
        stack.print();
        System.out.println(stack.pop());
        stack.push(55);
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());

    }

    public void push(int data){ // Add front
        Node toAdd = new Node(data);
        if (top != null) {
            toAdd.next = top;
        }
        top = toAdd;
    }

    public int pop(){ // Delete front
        if(top == null) return -1;
        Node temp = top;
        top = temp.next;
        temp.next = null;
        return temp.data;
    }

    public int peek(){
        if(top == null) return -1;
        return top.data;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void print(){
        Node temp = top;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
