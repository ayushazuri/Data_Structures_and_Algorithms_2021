import java.util.ArrayList;

public class FindPath {
    static ArrayList<Integer> path = new ArrayList<>();
    static class Node
    {
        int data;
        Node left = null, right = null;

        Node(int key) {
            this.data = key;
        }
    }

    static boolean findPath(Node root, int n, ArrayList<Integer> path){
        if(root == null)
            return false;

        path.add(root.data);
        if(root.data == n)
            return true;
        if(root.left != null && findPath(root.left, n, path))
            return true;
        if(root.right != null && findPath(root.right, n, path))
            return true;

        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);


        System.out.println(findPath(root, 4, path));
        System.out.println(path);

    }

}
