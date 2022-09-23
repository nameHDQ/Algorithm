package DayOne.simple;

import java.util.ArrayList;
import java.util.List;

public class N257 {

    List<String> rs = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {

        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        return rs;
    }
    public void dfs(TreeNode root, List<TreeNode> list){
        list.add(root);
        if (root.left == null && root.right == null){
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                if (i == list.size() - 1) {
                    stringBuilder.append(list.get(i).val);
                }else {
                    stringBuilder.append(list.get(i).val).append("->");
                }
            }
            rs.add(stringBuilder.toString());
            list.remove(list.size() - 1);
            return;
        }
        if (root.left != null) dfs(root.left, list);
        if (root.right != null) dfs(root.right, list);
        list.remove(list.size() - 1);
    }
}
