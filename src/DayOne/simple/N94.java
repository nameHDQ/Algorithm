package DayOne.simple;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author hdq
 * @create 2022-02-25 10:45
 */
public class N94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
//        if (root != null) {
//            medium(root, result);
//        }
        if (root == null){
            return result;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (root != null || !deque.isEmpty()){

            //  一直遍历左子树
            while (root != null){
                deque.push(root);
                root = root.left;
            }
            // 现在root为空， 退回父节点

            root = deque.pop();
            result.add(root.val);

            if (root.right != null){
                root = root.right;
            }else {
                root = null;
            }
        }
        return result;
    }

    private void medium(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        medium(root.left, result);
        result.add(root.val);
        medium(root.right, result);
    }
}
