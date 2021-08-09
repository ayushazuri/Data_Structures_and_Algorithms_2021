import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class VerticalOrderTraversal {
    static class Node
    {
        int key;
        Node left;
        Node right;

        // Constructor
        Node(int data)
        {
            key = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
        System.out.println("Vertical Order traversal is");
        printVerticalOrder(root);
    }

    private static void printVerticalOrder(Node root) {
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        getVerticalOrder(root, 0, map);
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet())
        {
            System.out.println(entry.getValue());
        }
    }

    private static void getVerticalOrder(Node root, int dist, TreeMap<Integer, ArrayList<Integer>> map) {
        if(root == null) return;

        ArrayList<Integer> al = map.get(dist);
        if(al == null){
            al = new ArrayList<>();
            al.add(root.key);
        }else{
            al.add(root.key);
        }

        map.put(dist, al);

        getVerticalOrder(root.left, dist-1, map);
        getVerticalOrder(root.right, dist+1, map);
    }
}
