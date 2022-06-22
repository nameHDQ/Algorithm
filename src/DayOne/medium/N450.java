package DayOne.medium;

/**
 * @author hdq
 * @create 2022-06-02 10:07
 */
public class N450 {
    // 返回的是删除root子节点中key后 新节点的值
    public TreeNode deleteNode(TreeNode root, int key) {
        // 不包含key
        if (root == null){
            return null;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode temp = root.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            root.right = deleteNode(root.right, temp.val);
            temp.left = root.left;
            temp.right = root.right;
            return temp;
        }

        return root;
    }
}
