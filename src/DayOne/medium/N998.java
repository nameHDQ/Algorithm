package DayOne.medium;

public class N998 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {

        TreeNode temp = new TreeNode(val);

        if (root.val < val){
            temp.left = root;
            return temp;
        }
        TreeNode pre = root;
        TreeNode cur = root.right;
        while (cur != null){
            if (cur.val < val){
                pre.right = temp;
                temp.left = cur;
                return root;
            }else {
                pre = cur;
                cur = cur.right;
            }
        }
        pre.right = temp;
        return root;
    }
}
