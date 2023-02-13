package DayOne.medium;

import java.util.ArrayList;
import java.util.List;

public class N98 {
    List<Integer> temp = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        dfs(root);
        if (temp.size() <= 1){
            return true;
        }
        for (int i = 1; i < temp.size(); i++) {
            if (temp.get(i) < temp.get(i - 1)){
                return false;
            }
        }
        return true;
    }

    public void dfs(TreeNode root){
        if (root == null){
            return;
        }
        if (root.left != null){
            dfs(root.left);
        }
        temp.add(root.val);
        if (root.right != null){
            dfs(root.right);
        }
    }
}
