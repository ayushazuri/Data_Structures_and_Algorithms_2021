public class CheckLeavesAtSameLevel {
    class Node{
        int data;
        Node left;
        Node right;
        Node(int item){
            data = item;
            left = right = null;
        }
    }

    static int fixedLevel = 0;
    public boolean checkLeaves(Node root, int level){
        if(root == null) return true;

        if(root.left == null && root.right == null){
            if(fixedLevel == 0){
                fixedLevel = level;
                return true;
            }

            return fixedLevel == level;
        }

        return checkLeaves(root.left, level+1) && checkLeaves(root.right, level+1);
    }
}
