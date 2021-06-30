//https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1/?company[]=Amazon&company[]=Amazon&page=1&query=company[]Amazonpage1company[]Amazon#

public class DeleteNodeWithoutHead {
    class Node
    {
        int data ;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {

    }
    void deleteNode(Node del)
    {
        // Your code here
        while(del.next.next != null){
            del.data = del.next.data;
            del = del.next;
        }
        del.data = del.next.data;
        del.next = null;
    }
}
