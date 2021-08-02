public class Leetcode_783 {
    class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int val){
            this.val = val;
        }
    }
    class Solution {
        int min = Integer.MAX_VALUE;
        Integer prev = null;
        public int minDiffInBST(TreeNode root) {
            inOrder(root);
            return min;
        }
        public void inOrder(TreeNode root){
            if(root == null) return;

            inOrder(root.left);

            if(prev != null)
                min = Math.min(min, root.val - prev);
            prev = root.val;

            inOrder(root.right);
        }
    }
}
