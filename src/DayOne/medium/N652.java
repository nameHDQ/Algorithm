package DayOne.medium;

import java.util.*;

public class N652 {

    Map<String, TreeNode> map = new HashMap<>();
    Set<TreeNode> seen = new HashSet<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<>(seen);
    }

    public String dfs(TreeNode root){
        if (root == null){
            return null;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append("(").append(dfs(root.left)).append(")")
                .append("(").append(dfs(root.right)).append(")");

        String str = sb.toString();
        if (map.containsKey(str)){
            seen.add(map.get(str));
        }else {
            map.put(str, root);
        }
        return str;
    }
}
