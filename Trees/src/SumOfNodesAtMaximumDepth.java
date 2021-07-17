public class SumOfNodesAtMaximumDepth {
    static class Node {
        int data;
        Node left;
        Node right;
    }

    static Node createNode(int val){
        Node node = new Node();
        node.data = val;
        node.left = null;
        node.right = null;
        return node;
    }
    static int sum = 0, maxLevel = -1;
    private static void sumOfNodesAtMaxDepth(Node root, int level) {
        if(root == null) return;

        if(level > maxLevel){
            sum = root.data;
            maxLevel = level;
        }else if(level == maxLevel)
            sum += root.data;

        sumOfNodesAtMaxDepth(root.left, level + 1);
        sumOfNodesAtMaxDepth(root.right, level + 1);
    }

    public static void main(String[] args) {
        Node root = null;
        root = createNode(1);
        root.left = createNode(2);
        root.right = createNode(3);
        root.left.left = createNode(4);
        root.left.right = createNode(5);
        root.right.left = createNode(6);
        root.right.right = createNode(7);

        sumOfNodesAtMaxDepth(root, 0);
        System.out.println(sum);
    }

}
