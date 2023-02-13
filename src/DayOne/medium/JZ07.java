package DayOne.medium;

import java.util.HashMap;
import java.util.Map;

public class JZ07 {
    public Map<Integer, Integer> index =  new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 记录root的index，根据index划分左子树右子树区域
        for (int i = 0; i < inorder.length; i++) {
            index.put(inorder[i], i);
        }
        TreeNode root = build(preorder, inorder, 0, preorder.length - 1,
                0,inorder.length - 1);
        return root;
    }

    public TreeNode build(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight){
        if (preLeft > preRight) return null;
        if (inLeft > inRight) return null;
        int rootIndex = index.get(preLeft);
        int leftLen = rootIndex - inLeft;
        TreeNode root = new TreeNode(preorder[preLeft]);
        root.left = build(preorder, inorder, preLeft + 1, preLeft + leftLen,inLeft, rootIndex - 1);
        root.right = build(preorder, inorder, preLeft + leftLen + 1, preRight, rootIndex + 1, inRight);
        return root;
    }
}
