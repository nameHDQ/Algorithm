package DayOne.medium;

public class N236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode parent = dfs(root, p, q);

        return parent;
    }

    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){
        if (root == null) return null;


        if (root.val == p.val || root.val == q.val) return root;

        root.left = dfs(root.left, p, q);
        root.right = dfs(root.right, p, q);
        if (root.left != null && root.right != null){
            return root;
        }
        if (root.left != null) return root.left;
        if (root.right != null) return  root.right;
        return null;
    }
}
