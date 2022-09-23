package DayOne.simple;

import java.util.ArrayDeque;
import java.util.Deque;

public class N404 {
    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()){
            TreeNode pop = deque.pop();
            if (pop.right != null) deque.push(pop.right);
            if (pop.left != null) {
                if (pop.left.left == null && pop.left.right == null){
                    res += pop.left.val;
                }
                deque.push(pop.left);

            }
        }
        return res;
    }
}
