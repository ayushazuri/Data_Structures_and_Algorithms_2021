public class FLoorCeil {
    static int ceil = Integer.MIN_VALUE, flr = Integer.MAX_VALUE;
    static class Node
    {
        int data;
        Node left = null, right = null;

        Node(int key) {
            this.data = key;
        }
    }
    static void findCeilFloor(Node root, int key){
        if(root == null) return;

        if(root.data == key){
            flr = key;
            ceil = key;
        }else if(root.data > key){
            ceil = key;
            findCeilFloor(root.left, key);
        }else if(root.data < key){
            flr = key;
            findCeilFloor(root.right, key);
        }
    }
}
