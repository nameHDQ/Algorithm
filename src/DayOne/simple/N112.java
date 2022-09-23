package DayOne.simple;

import java.util.concurrent.TransferQueue;

public class N112 {
    boolean result = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        dfs(root, targetSum, root.val);
        return result;
    }

    public void dfs(TreeNode root, int targetSum,int curSum){
        if (root.left == null && root.right == null){
            if (targetSum == curSum) {
                result = true;
                return;
            }
        }
        if (root.left != null) dfs(root.left, targetSum, curSum + root.left.val);
        if (root.right != null) dfs(root.right, targetSum, curSum + root.right.val);
    }
}
