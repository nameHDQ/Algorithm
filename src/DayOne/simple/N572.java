package DayOne.simple;

/**
 * @author hdq
 * @create 2021-12-10 10:55
 */
public class N572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);

    }
    public boolean dfs(TreeNode root, TreeNode subRoot){
        if (root == null){
            return false;
        }
        return check(root, subRoot) || dfs(root.left, subRoot) || dfs(root.right, subRoot);
    }
    public boolean check(TreeNode root, TreeNode subRoot)
    {
        if (root == null && subRoot == null){
            return true;
        }
        if (root == null || subRoot == null || subRoot.val != root.val){
            return false;
        }
        return check(root.left, subRoot.left) &&check(root.right, subRoot.right);
    }
}
