package CodeTop;

import Utils.TreeNode;

public class N236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = dfs(root, p, q);
        return res;
    }

    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){
        if (root == null){  //exit
            return null;
        }
        if (p.val == root.val && q.val == root.val){    //the one
            return root;
        }


        if(p.val == root.val || q.val == root.val){ // one
            return root;
        }
        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);
        if (left != null && right != null){ // two edge
            return root;
        }
        return left == null ? right : left; //one or null
    }
}
