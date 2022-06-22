package DayOne.simple;

/**
 * @author hdq
 * @create 2022-05-30 13:17
 */
public class N1022 {
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        dfs(root, root.val);
        return sum;
    }
    public void dfs(TreeNode root, int tempSum){
        // 判断是否为叶子节点
        if (root.left == null && root.right == null){
            sum += tempSum;
            return;
        }
        tempSum = tempSum * 2;
        if (root.left != null){
            dfs(root.left, tempSum + root.left.val);
        }
        if (root.right != null){
            dfs(root.right, tempSum + root.right.val);
        }
    }

    public static void main(String[] args) {
//[0,1,0,0,null,0,0,null,null,null,1,null,null,null,1]
    }
}
