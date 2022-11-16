package DayOne.medium;

import java.util.HashMap;
import java.util.Map;

public class N337 {
    public Map<TreeNode, Integer> cMap = new HashMap<>();
    public Map<TreeNode, Integer> iMap = new HashMap<>();
    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(cMap.getOrDefault(root,0), iMap.getOrDefault(root, 0));
    }


    public void dfs(TreeNode root){

        if (root == null){
            return ;
        }
        dfs(root.left);
        dfs(root.right);
        cMap.put(root, root.val + iMap.getOrDefault(root.left, 0) + iMap.getOrDefault(root.right, 0));
        iMap.put(root,    Math.max(iMap.getOrDefault(root.left, 0), cMap.getOrDefault(root.left, 0)) + Math.max(iMap.getOrDefault(root.right, 0), cMap.getOrDefault(root.right, 0)));
    }
}
