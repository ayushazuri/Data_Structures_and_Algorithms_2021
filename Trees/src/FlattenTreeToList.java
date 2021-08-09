public class FlattenTreeToList {
    static class Node
    {
        int data;
        Node left = null, right = null;

        Node(int key) {
            this.data = key;
        }
    }

    static Node prev = null;
    static void flattenRec(Node node){
        if(node == null)
            return;

        flattenRec(node.right);
        flattenRec(node.left);

        node.right = prev;
        node.left = null;
        prev = node;
    }
}
