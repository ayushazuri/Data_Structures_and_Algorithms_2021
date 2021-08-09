import java.util.Stack;

public class IterativeTraversal {

    static class Node
    {
        int data;
        Node left = null, right = null;

        Node(int key) {
            this.data = key;
        }
    }

    public static void main(String[] args) {
        Node root;

    }

    static void inOrderRec(Node root){
        Stack<Node> s = new Stack<>();
        Node curr = root;
        while(!s.isEmpty() || curr != null){
            if(curr != null){
                s.push(curr);
                curr = curr.left;
            }else{
                Node temp = s.pop();
                System.out.println(temp.data);
                curr = curr.right;
            }
        }
    }

    static void preOrder(Node root){
        Stack<Node> s = new Stack<>();

        s.push(root);
        while(!s.isEmpty()){
            Node curr = s.pop();
            System.out.println(curr.data);
            if(curr.right != null)
                s.push(curr.right);
            if(curr.left != null)
                s.push(curr.left);
        }
    }

    static void postOrder(Node root){
        Stack<Node> s = new Stack<>();
        Stack<Node> out = new Stack<>();

        s.push(root);
        while(!s.isEmpty()){
            Node curr = s.pop();
            out.push(curr);

            if(curr.left != null)
                s.push(curr.left);
            if(curr.right != null)
                s.push(curr.right);
        }
        while(!out.isEmpty()){
            System.out.println(out.pop());
        }
    }
}
