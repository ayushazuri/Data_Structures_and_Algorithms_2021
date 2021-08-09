import java.util.ArrayDeque;
import java.util.Deque;

public class SpiralLevelOrder {
    static class Node
    {
        int key;
        Node left = null, right = null;

        Node(int key) {
            this.key = key;
        }
    }

    public static void spiralOrderTraversal(Node root)
    {
        if (root == null) {
            return;
        }
        Deque<Node> deque = new ArrayDeque<>();
        deque.addFirst(root);
        boolean flag = false;

        while (!deque.isEmpty())
        {
            int nodeCount = deque.size();
            if (flag)
            {
                while (nodeCount > 0)
                {
                    Node curr = deque.pollFirst();
                    System.out.print(curr.key + " ");

                    if (curr.left != null) {
                        deque.addLast(curr.left);
                    }

                    if (curr.right != null) {
                        deque.addLast(curr.right);
                    }

                    nodeCount--;
                }
            }
            else {
                while (nodeCount > 0)
                {
                    Node curr = deque.pollLast();
                    System.out.print(curr.key + " ");    // print front node

                    if (curr.right != null) {
                        deque.addFirst(curr.right);
                    }

                    if (curr.left != null) {
                        deque.addFirst(curr.left);
                    }

                    nodeCount--;
                }
            }
            flag = !flag;
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);

        spiralOrderTraversal(root);
    }
}
