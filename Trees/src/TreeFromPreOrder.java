public class TreeFromPreOrder {
      public static class TreeNode {
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
     static int index = 0;
    public static TreeNode bstFromPreorder(int[] preorder) {
        return convert(preorder, index, preorder[index], Integer.MIN_VALUE, Integer.MAX_VALUE, preorder.length);
    }

    public static TreeNode convert(int[] preorder, int index, int key, int min, int max, int size){
        if(index>= size)
            return null;

        TreeNode root = null;
        if(key > min && key < max) {
            root = new TreeNode(key);
            index++;

            if(index< size){
                root.left = convert(preorder, index, preorder[index], min, root.val, size);
            }
            if(index < size){
                root.right = convert(preorder, index, preorder[index], root.val, max, size);
            }
        }

        return root;
    }
}
