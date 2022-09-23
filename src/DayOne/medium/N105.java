package DayOne.medium;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class N105 {


    int[] preorder;
    int[] inorder;
    int preIdx;
    Map<Integer, Integer> map = new HashMap<>();



    public TreeNode built(int left, int right){

        if (left > right) return null;
        int rootValue = preorder[preIdx];
        TreeNode root = new TreeNode(rootValue);

        int rootIdx = map.get(rootValue);

        preIdx++;
        root.left = built(left, rootIdx - 1);
        root.right = built(rootIdx + 1, right);
        return root;
    }



    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorder = inorder;
        this.preorder = preorder;
        this.preIdx = 0;

        int idx = 0;
        for (int i : inorder) {
            map.put(i, idx++);
        }

        return built(0, inorder.length - 1);
    }
}
