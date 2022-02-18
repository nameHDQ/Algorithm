package DayOne.simple;

/**
 * @author hdq
 * @create 2021-11-26 11:06
 */
public class N700 {
    TreeNode TEM = null;
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null){
            return null;
        }
        if (root.val == val){
            return root;
        }else {
            if ((TEM = searchBST(root.left, val))!=null){
                return TEM;
            }else {
                return searchBST(root.right, val);
            }

        }
    }
}
