package DayOne;

/**
 * @author hdq
 * @create 2021-08-26 11:39
 */

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
public class N617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null){
            return root2;
        }
        if (root2 == null){
            return root1;
        }
        TreeNode root =new TreeNode();
        merge(root,root1,root2);
        return root;
    }
    public void merge(TreeNode root, TreeNode root1, TreeNode root2){
        if (root1 == null){
            root.val = root2.val;
            root.left=root2.left;
            root.right=root2.right;
            return;
        }
        if (root2 == null){
            root.val = root1.val;
            root.left=root1.left;
            root.right=root1.right;
            return;
        }
        root.val = root1.val+ root2.val;
        TreeNode rootleft =new TreeNode();
        TreeNode rootright =new TreeNode();
        root.left = rootleft;
        root.right =rootright;
        if (root1.left !=null && root2.left !=null){
            merge(root.left,root1.left,root2.left);
        }
        if (root1.right !=null && root2.right !=null){
            merge(root.right,root1.right,root2.right);
        }
        if (root1.left == null || root2.left == null) {
            if (root1.left == null){
                root.left = root2.left;
            }else{
                root.left = root1.left;
            }
        }
        if (root1.right == null || root2.right == null) {
            if (root1.right == null){
                root.right = root2.right;
            }else{
                root.right = root1.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);
        root1.right = treeNode2;
        root1.left = treeNode3;
        treeNode3.left = treeNode5;
        TreeNode treeNode21 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode treeNode23 = new TreeNode(3);
        TreeNode treeNode24 = new TreeNode(4);
        TreeNode treeNode27 = new TreeNode(7);
        root2.left = treeNode21;
        root2.right = treeNode23;
        treeNode21.right= treeNode24;
        treeNode23.right = treeNode27;
        N617 n617 = new N617();
        TreeNode treeNode = n617.mergeTrees(root1, root2);
        while (treeNode!=null){
            System.out.println(treeNode.val);
            treeNode = treeNode.right;
        }
    }
}
