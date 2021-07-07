import java.util.Map;
import java.util.TreeMap;

public class BottomView {
    static class Node
    {
        int data;
        Node left = null, right = null;

        Node(int key) {
            this.data = key;
        }
    }

    static class Pair<U, V> {
        public U node;
        public V level;
        Pair(U node, V level){
            this.node = node;
            this.level = level;
        }
        public static <U,V> Pair<U,V> of(U a, V b){
            return new Pair<U,V>(a, b);
        }

    }

    static void preorder(Node root){
        if(root!=null){
            System.out.print(root.data+ " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    public static void main(String[] args) {
//        Node x = new Node(1);
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
//        preorder(root);

        Map<Integer, Pair<Integer,Integer>> map = new TreeMap<>();
        printBottom(root, 0, 0, map);

        for (Pair<Integer, Integer> it: map.values()) {
            System.out.print(it.node + " ");
        }
    }

    public static void printBottom(Node root, int dist, int level, Map<Integer, Pair<Integer,Integer>> map){
        if(root == null)
            return;

        if(!map.containsKey(dist) || level >= map.get(dist).level)
            map.put(dist, Pair.of(root.data, level));

        printBottom(root.left, dist-1, level+1, map);
        printBottom(root.right, dist+1, level+1, map);
    }


}
