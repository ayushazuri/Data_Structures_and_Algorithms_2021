public class myQueuearr {
    int head = 0, rear = 0;
    int length = 10;
    int[] queue = new int[length];
    public static void main(String[] args) {
        myQueuearr queue = new myQueuearr();
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
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.print();
        queue.dequeue();
        queue.print();


    }

    public void enqueue(int data){
        if(rear >= length){
            System.out.println("Can not be added");
            return;
        }
        queue[rear] = data;
        rear++;
    }

    public void dequeue(){
        if(head == rear){
            System.out.println("Cant be deleted");
            head = rear = 0;
        }else{
            System.out.println(queue[head]);
            queue[head] = 0;
            head++;
        }
    }

    public void peek(){
        System.out.println(queue[head]);
    }

    public void print(){
        for(int i: queue){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
