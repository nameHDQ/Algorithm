package DayOne.simple;


/**
 * @author hdq
 * @create 2021-11-18 11:31
 */

//Definition for a binary tree node.
class TreeNode {
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


public class N563 {
    int total = 0;
    public int findTilt(TreeNode root) {
        dfs(root);
        return total;
    }
    public int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        total += Math.abs(left-right);
        return root.val;
    }
}
