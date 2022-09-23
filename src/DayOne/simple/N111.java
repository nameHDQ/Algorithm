package DayOne.simple;

public class N111 {
    public int minDepth(TreeNode root) {

        if (root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int lefDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if(root.left == null || root.right == null) return lefDepth + rightDepth + 1;
        return Math.min(lefDepth, rightDepth) + 1;
    }
}
