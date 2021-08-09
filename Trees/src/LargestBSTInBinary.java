public class LargestBSTInBinary {
    class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static class SubTreeInfo
    {
        int min, max;
        int size;
        boolean isBST;
        SubTreeInfo(){
        }
        SubTreeInfo(int min, int max, int size, boolean isBST) {
            this.min = min;
            this.max = max;
            this.size = size;
            this.isBST = isBST;
        }
    }

    static SubTreeInfo  checkBST(Node root){
        if(root == null)
            return new SubTreeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);

        SubTreeInfo left = checkBST(root.left);
        SubTreeInfo right = checkBST(root.right);

        SubTreeInfo res = new SubTreeInfo();
        if(left.isBST && right.isBST && (root.data > left.max) && (root.data < right.min)){
            res.isBST = true;
            res.min = Math.min(root.data, Math.min(left.min, right.min));
            res.max = (Math.max(root.data, Math.max(left.max, right.max)));
            res.size = left.size + right.size + 1;
        }else{
            res.min = 0;
            res.max = 0;
            res.size = Math.max(left.size, right.size);
            res.isBST = false;
        }
//        OR
//        if (left.isBST && right.isBST && (root.data > left.max && root.data < right.min)){
//            info = new SubTreeInfo(Math.min(root.data, Math.min(left.min, right.min)),
//                    Math.max(root.data, Math.max(left.max, right.max)), left.size + 1 + right.size, true);
//        }else {
//            info = new SubTreeInfo(0, 0, Math.max(left.size, right.size), false);
//        }

        return res;
    }
}
