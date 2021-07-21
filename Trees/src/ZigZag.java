import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZag {
    static class Node
    {
        int data;
        Node left;
        Node right;
        Node(int data)
        {
            this.data = data;
        }
    }

    private static void zigzag(Node root) {
        if(root == null ) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> al = new ArrayList<>();
            while(size-- > 0){
                Node temp = q.remove();
                al.add(temp.data);

                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
            }

            if(count % 2 != 0){
                Collections.reverse(al);
            }
            for(int i: al){
                System.out.println(i);
            }
            al.clear();
            count++;
        }
    }

    public static void main(String[] args) {
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(7);
        tree.left.right = new Node(6);
        tree.right.left = new Node(5);
        tree.right.right = new Node(4);

        zigzag(tree);
    }


}
