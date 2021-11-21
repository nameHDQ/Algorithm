package DayOne.medium;

import java.util.*;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

/**
 * @author hdq
 * @create 2021-10-17 18:32
 */
public class N230 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> allNum = new ArrayList<>();
        if (root != null){
            dfs(root,allNum);
        }
        Collections.sort(allNum);
        for (int i = 0; i < allNum.size(); i++) {
            System.out.println(allNum.get(i));
        }
        return allNum.get(k-1);
    }
    public void dfs(TreeNode root,List list){
        if (root != null){
            list.add(root.val);
            dfs(root.left, list);
            dfs(root.right, list);
        }
    }

    public static void main(String[] args) {
        N230 n230 = new N230();
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode1 = new TreeNode(1);
        treeNode3.left = treeNode1;
        treeNode3.right = treeNode4;
        treeNode1.right = treeNode2;
        System.out.println(n230.kthSmallest(treeNode3, 1));
    }
}
