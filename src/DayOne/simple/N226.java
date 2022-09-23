package DayOne.simple;

public class N226 {
    public TreeNode invertTree(TreeNode root) {

        if (root ==  null) return root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
