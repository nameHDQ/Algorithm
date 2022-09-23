package DayOne.simple;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class N637 {
    public List<Double> averageOfLevels(TreeNode root) {


        Deque<TreeNode> deque = new ArrayDeque<>();

        deque.add(root);


        List<Double> res =new ArrayList<>();

        while (!deque.isEmpty()){

            int size = deque.size();
            double temp = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (poll.left != null) deque.add(poll.left);
                if (poll.right != null) deque.add(poll.right);

                temp += poll.val;
            }
            res.add(temp / size);

        }
        return res;
    }
}
