package competition.fall2022;

import Utils.TreeNode;

public class N2 {
    public TreeNode expandBinaryTree(TreeNode root) {

        if (root == null) return root;

        if (root.left != null){
            TreeNode temp = new TreeNode(-1);

            temp.left = root.left;
            root.left = temp;
            expandBinaryTree(temp.left);
        }
        if (root.right != null){
            TreeNode temp = new TreeNode(-1);
            temp.right = root.right;
            root.right = temp;
            expandBinaryTree(temp.right);
        }
        return root;
    }

}
