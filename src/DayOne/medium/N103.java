package DayOne.medium;

import java.util.*;

public class N103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int index = 0;
        while (!deque.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.remove();
                if (cur.left != null){
                    deque.add(cur.left);
                }
                if (cur.right != null){
                    deque.add(cur.right);
                }
                temp.add(cur.val);
            }
            if (index % 2 != 0){
                Integer[] arrs = temp.toArray(new Integer[0]);
                int left = 0;
                int right = arrs.length - 1;
                while (left < right){
                    int t = arrs[left];
                    arrs[left++] =arrs[right];
                    arrs[right--] = t;
                }
                temp.clear();
                temp.addAll(Arrays.asList(arrs));
            }
            res.add(temp);
            index++;
        }
        return res;
    }
}
