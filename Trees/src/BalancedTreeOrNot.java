public class BalancedTreeOrNot {
    static class Node
    {
        int data;
        Node left = null, right = null;

        Node(int key) {
            this.data = key;
        }
    }
    static boolean isBal = true;
    public static int isBalanced(Node node){
        if(node == null) return 0;

        int lHeight = isBalanced(node.left);
        int rHeight = isBalanced(node.right);

        if(Math.abs(lHeight - rHeight) > 1)
            isBal = false;

        return Math.max(lHeight, rHeight)+1;

    }
}
