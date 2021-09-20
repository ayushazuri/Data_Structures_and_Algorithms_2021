public class Cousins {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    TreeNode xParent = null;
    TreeNode yParent = null;
    int xDepth = -1, yDepth = -1;
    public boolean isCousins(TreeNode root, int x, int y) {
        getDepthAndParent(root, x, y, 0, null);

        return xDepth == yDepth && xParent != yParent;
    }

    public void getDepthAndParent(TreeNode root, int x, int y, int level, TreeNode parent){
        if(root == null) return;

        if(root.val == x){
            xDepth = level;
            xParent = parent;
        }else if(root.val == y){
            yDepth = level;
            yParent = parent;
        }else{
            getDepthAndParent(root.left, x, y, level + 1, root);
            getDepthAndParent(root.right, x, y, level + 1, root);
        }
    }
}
