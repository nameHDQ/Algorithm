package DayOne.medium;

import java.util.Deque;

public class N513 {
    int height = -1;
    int rs = 0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return rs;
    }

    public void dfs(TreeNode root, int curHeight){
        if (root == null) {
            return;
        }
        curHeight++;
        dfs(root.left, curHeight);
        dfs(root.right, curHeight);

        if (curHeight > height){
            height = curHeight;
            rs = root.val;
        }

    }
}
