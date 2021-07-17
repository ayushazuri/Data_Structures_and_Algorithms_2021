public class PrintBoundaries {
        Node root;
    static class Node {
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
    }

    private static void printBoundary(Node root){
            if(root == null) return;

            System.out.print(root.data + " ");
            printLeftBoundary(root.left);
            printLeaves(root.left);
            printLeaves(root.right);
            printRightBoundary(root.right);
    }

    private static void printRightBoundary(Node root) { //Bottom UP approach
        if(root == null) return;

        if(root.right != null){
            printLeftBoundary(root.right);
            System.out.print(root.data + " ");
        }else if(root.left != null){
            printLeftBoundary(root.left);
            System.out.print(root.data + " ");
        }
    }

    private static void printLeaves(Node root) { // Left to Right
            if(root == null) return;

            if(root.left == null && root.right == null)
                System.out.print(root.data + " ");

            printLeaves(root.left);
            printLeaves(root.right);
    }

    private static void printLeftBoundary(Node root) { //Top Down Approach
            if(root == null) return;

            if(root.left != null){
                System.out.print(root.data + " ");
                printLeftBoundary(root.left);
            }else if(root.right != null){
                System.out.print(root.data + " ");
                printLeftBoundary(root.right);
            }
    }

    public static void main(String[] args) {
        PrintBoundaries tree = new PrintBoundaries();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.root.right = new Node(22);
        tree.root.right.right = new Node(25);
        printBoundary(tree.root);
    }
}
