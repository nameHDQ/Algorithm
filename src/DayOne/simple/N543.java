package DayOne.simple;

public class N543 {
    int maxLen = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return maxLen;
    }

    public int dfs(TreeNode root){
        if (root.left == null && root.right == null){
            return 0;
        }

        int left = root.left == null ? 0 : dfs(root.left) +  1;
        int right = root.right == null ? 0 : dfs(root.right) +  1;
        maxLen = Math.max(left +  right, maxLen);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        new N543().diameterOfBinaryTree(root);
    }
}
