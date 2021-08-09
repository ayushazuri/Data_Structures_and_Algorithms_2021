import java.util.HashMap;

public class TreeFromPreOrderInOrder {
    static class Node
    {
        int data;
        Node left = null, right = null;

        Node(int key) {
            this.data = key;
        }
    }
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int preInd = 0;

    public static void main(String[] args) {
        int[] in = {1, 2, 30}; //dummy data
        int[] pre = {2, 1, 30};

        for(int i: in){
            map.put(in[i], i);
        }
        conversion(in, pre, 0, in.length-1);
    }

    static Node conversion(int[] in, int[] pre, int start, int end){
        if(start > end) return null;

        Node root = new Node(pre[preInd++]);

        if(start == end)
            return root;

        int index = map.get(root.data); // First do linear search then start with the map version. linear search method with take O(n2). Map takes
        // O(n)

        root.left = conversion(in, pre, start, index-1);
        root.right = conversion(in, pre, index+1, end);
        return root;
    }
}
