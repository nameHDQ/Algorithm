package DayOne.medium;

import java.util.Stack;

public class N654 {
//    public TreeNode constructMaximumBinaryTree(int[] nums) {
//
//        return construct(0, nums.length, nums);
//    }
//    public TreeNode construct(int left, int right, int[] nums){
//        if (left >= right) return null;
//
//        int max_index = left;
//        for (int i = left + 1; i < right; i++) {
//            if (nums[i] > nums[max_index]){
//                max_index = i;
//            }
//        }
//        TreeNode root = new TreeNode(nums[max_index]);
//        root.left = construct(left, max_index, nums);
//        root.right = construct(max_index + 1, right, nums);
//
//        return root;
//    }


    static TreeNode[] stk = new TreeNode[1010];
    public TreeNode constructMaximumBinaryTree1(int[] nums) {
        int he = 0, ta = 0;
        for (int x : nums) {
            TreeNode node = new TreeNode(x);
            while (he < ta && stk[ta - 1].val < x) node.left = stk[--ta];
            if (he < ta) stk[ta - 1].right = node;
            stk[ta++] = node;
        }
        return stk[0];
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(-1);
        for (int num : nums) {
            TreeNode node = new TreeNode(num);
            if ( num > root.val) root = node;
            while (!stack.isEmpty() && stack.peek().val < num){
                node.left = stack.pop();
            }
            if (!stack.isEmpty()){
                stack.peek().right = node;
            }
            stack.push(node);
        }
        return root;
    }




    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        new N654().constructMaximumBinaryTree(nums);
    }


}
