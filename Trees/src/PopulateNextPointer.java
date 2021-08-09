import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextPointer {
    static class Node
    {
        int data;
        Node left = null, right = null, nextRight = null;

        Node(int key) {
            this.data = key;
        }
    }

    static Node populateRight(Node root){
        if(root == null) return null;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr == null && q.isEmpty())
                return root;
            else if(curr == null){
                q.add(null);
                continue;
            }else{
                curr.nextRight = q.peek();
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }
        }
        return root;
    }
}
