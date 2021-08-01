//Given the root of a binary tree and an integer targetSum,
// return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
//https://leetcode.com/problems/path-sum/
public class Leetcode_112 {
    class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int val){
            this.val = val;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        targetSum = targetSum - root.val;
        if(targetSum == 0 && root.left == null && root.right == null)
            return true;

        if(hasPathSum(root.left, targetSum))
            return true;
        if(hasPathSum(root.right, targetSum))
            return true;

        return false;
    }
}
