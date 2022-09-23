package DayOne.medium;

import java.util.HashMap;
import java.util.Map;

public class N106 {


    int rootIdx;
    int[] inorder;
    int[] postorder;

    Map<Integer, Integer> map = new HashMap<>();


    public TreeNode helper(int left, int right){

        if (left > right) return null;

        int root_val = postorder[rootIdx];
        TreeNode root = new TreeNode(root_val);
        Integer index = map.get(root_val);
        rootIdx--;
        root.right = helper(index + 1, right);
        root.left = helper(left, index - 1);
        return root;
    }


    public TreeNode buildTree(int[] inorder, int[] postorder) {

        this.inorder = inorder;
        this.postorder = postorder;
        this.rootIdx = inorder.length - 1;

        int idx = 0;
        for (int i : inorder) {
            map.put(i, idx++);
        }
        return helper(0, postorder.length - 1);
    }
}
