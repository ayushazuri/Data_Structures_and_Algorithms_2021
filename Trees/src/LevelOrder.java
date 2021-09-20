import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
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

    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        levelOrderHelper(res, root, 0);
        return res;
    }

    public void levelOrderHelper(List<List<Integer>> res, TreeNode root, int level) {
        if(root == null) return;
        List<Integer> curr;

        if(level >= res.size()){
            curr = new ArrayList<>();
            curr.add(root.val);
            res.add(curr);
        }else{
            curr = res.get(level);
            curr.add(root.val);
        }

        levelOrderHelper(res, root.left, level + 1);
        levelOrderHelper(res, root.right, level + 1);
    }
     public List<List<Integer>> levelOrder2(TreeNode root) {
         List<List<Integer>> res = new ArrayList<>();

         if(root == null) return res;

         Queue<TreeNode> q = new LinkedList<>();
         q.add(root);

         while(!q.isEmpty()){
             int size = q.size();
             List<Integer> r = new ArrayList<>();

             while(size-- > 0){
                 TreeNode temp = q.poll();
                 r.add(temp.val);

                 if(temp.left != null)
                     q.add(temp.left);
                 if(temp.right != null)
                     q.add(temp.right);
             }

             res.add(r);
         }

         return res;
     }
}
