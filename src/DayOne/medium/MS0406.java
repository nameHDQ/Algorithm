package DayOne.medium;

/**
 * @author hdq
 * @create 2022-05-16 13:43
 */
public class MS0406 {
    TreeNode result = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        while (root != null) {
            if (root.val <= p.val) {
                root = root.right;
            }else {
                result = root;
                root = root.left;
            }
        }
        return result;
    }

}
