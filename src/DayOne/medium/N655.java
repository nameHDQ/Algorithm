package DayOne.medium;

import java.util.*;

public class N655 {
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);

        int line = height;
        int row = (1 << height) - 1;

        int root_idx = (row - 1) / 2;
        List<List<String>> res = new ArrayList<>();
        List<String> cur_list = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            if (i == root_idx){
                cur_list.add("" + root.val);
            }else {
                cur_list.add("");
            }
        }
        res.add(cur_list);
        Deque<TreeNode> layer = new ArrayDeque<>();
        int cur_level = -1;
        layer.add(root);
        while (layer.size() > 0) {
            cur_level ++;
            int size = layer.size();
            List<String> new_list = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                new_list.add("");
            }
            for (int i = 0; i < row; i++) {
                if (!cur_list.get(i).equals("")){
                    TreeNode pop = layer.pop();
                    if (pop.left != null) {
                        layer.add(pop.left);
                        System.out.println(1<<(height - 1 - cur_level - 1));
                        new_list.set(i - (1<<(height - 1 - cur_level - 1)), String.valueOf(pop.left.val));
                    }
                    if (pop.right != null) {
                        layer.add(pop.right);
                        System.out.println(1<<(height - 1 - cur_level - 1));
                        new_list.set(i + (1<<(height - 1 - cur_level - 1)), String.valueOf(pop.right.val));
                    }
                }
            }
            if (cur_level == height - 2) break;
            res.add(new_list);
            cur_list = new_list;
        }
        return res;
    }
    public int getHeight(TreeNode root){
        int height = 0;

        Deque<TreeNode> layer = new ArrayDeque<>();

        layer.add(root);

        while (layer.size() > 0){

            int size = layer.size();
            for (int i = 0; i < size; i++) {

                TreeNode curNode = layer.pop();

                if (curNode.left != null) layer.add(curNode.left);
                if (curNode.right != null) layer.add(curNode.right);
            }
            height ++;

        }
        return height;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        new N655().printTree(root);
    }
}
