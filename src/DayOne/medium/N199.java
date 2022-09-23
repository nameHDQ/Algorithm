package DayOne.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class N199 {
    public List<Integer> rightSideView(TreeNode root) {

        Deque<TreeNode> deque = new ArrayDeque<>();

        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        deque.add(root);

        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = deque.poll();
                if (temp.left != null) deque.add(temp.left);
                if (temp.right != null) deque.add(temp.right);
                if (i == size - 1){
                    res.add(temp.val);
                }
            }
        }
        return res;
    }
}
