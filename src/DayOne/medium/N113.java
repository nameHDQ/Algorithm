package DayOne.medium;

import java.util.*;

public class N113 {
    List<List<Integer>> rs = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if (root == null) return rs;
        path.add(root.val);
        dfs(root, targetSum, root.val);
        return rs;
    }

    public void dfs(TreeNode root, int targetSum,int curSum){


        if (root.left == null && root.right == null){
            if (curSum == targetSum){
                rs.add(new ArrayList<>(path));
            }
            return;
        }
        if (root.left != null)  {
            path.add(root.left.val);
            dfs(root.left, targetSum, curSum + root.left.val);
            path.remove(path.size() - 1);
        }
        if (root.right != null)  {
            path.add(root.right.val);
            dfs(root.right, targetSum, curSum + root.right.val);
            path.remove(path.size() - 1);
        }
    }
}
