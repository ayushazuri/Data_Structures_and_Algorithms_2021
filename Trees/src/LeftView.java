import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class LeftView {
    static class Node
    {
        int data;
        Node left = null, right = null;

        Node(int key) {
            this.data = key;
        }
    }

    static void iterative(Node root){
        if (root == null) {
            return;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        Node curr;

        while (!queue.isEmpty())
        {
            int size = queue.size();
            int i = 0;

            while (i++ < size)
            {
                curr = queue.poll();
                if (i == 1) {
                    System.out.print(curr.data + " ");
                }
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
    }
    static void recurMap(Node root){
        HashMap<Integer, Integer> map = new HashMap<>();
        recurMapUtil(1, root, map);
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            System.out.println(e.getKey());
        }
    }

    private static void recurMapUtil(int level, Node root, HashMap<Integer, Integer> map) {
        if(root == null) return;
        map.putIfAbsent(level, root.data);

        recurMapUtil(level+1, root.left, map);
        recurMapUtil(level+1, root.right, map);
    }

    static int maxLevel = 0;
    static void recurLevel(Node root){
        recurLevelUtil(root, 1);
    }

    private static void recurLevelUtil(Node root, int level) {
        if(root == null) return;

        if(level > maxLevel){
            maxLevel = level;
            System.out.println(root.data);
        }

        recurLevelUtil(root.left, level+1);
        recurLevelUtil(root.right, level+1);
    }
}
