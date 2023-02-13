package DayOne.hard;

import Utils.TreeNode;

public class N124 {

    int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxValue;
    }


    public int dfs(TreeNode root) {
        if (root == null) return -1000000;

        int left = dfs(root.left);
        int right = dfs(root.right);

        int backValue = Math.max(Math.max(left + root.val, right + root.val), root.val);
        int leftOrRight = Math.max(backValue, left + right + root.val);
        int temp  = Math.max(Math.max(left, right), leftOrRight);
        maxValue = Math.max(temp, maxValue);
        return backValue;
    }
}
