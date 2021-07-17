public class SumOfNodeWithEvenGrandParent {
    static class TreeNode
    {
        int data;
        TreeNode left, right;
        TreeNode(int x)
        {
            data = x;
            left = right = null;
        }
    }
    static int sum = 0;
    public static void getSum(TreeNode curr, TreeNode parent, TreeNode grandP){
        if(curr == null) return;

        if(grandP != null && grandP.data % 2 == 0)
            sum += curr.data;

        getSum(curr.left, curr, parent);
        getSum(curr.right, curr, parent);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(22);

        root.left = new TreeNode(3);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);

        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(9);
        root.right.right.right = new TreeNode(2);

        getSum(root, null, null);
        System.out.println(sum);
    }
}
