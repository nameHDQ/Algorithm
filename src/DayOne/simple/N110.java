package DayOne.simple;

public class N110 {
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {

        if (root == null){
            return true;
        }
        depth(root);
        return flag;
    }

    public int depth(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1){
            flag = false;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
