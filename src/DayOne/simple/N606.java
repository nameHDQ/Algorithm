package DayOne.simple;

/**
 * @author hdq
 * @create 2022-03-19 11:35
 */
public class N606 {
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root,sb);
        return new String(sb);
    }
    public void dfs(TreeNode root,StringBuilder sb){
        if(root==null){
            return;
        }
        sb.append(root.val);
        // 只要有子节点  那么左子节点的括号要有
        if(root.left!=null||root.right!=null){
            sb.append("(");
            dfs(root.left,sb);
            sb.append(")");
        }
        if(root.right!=null){
            sb.append("(");
            dfs(root.right,sb);
            sb.append(")");
        }
    }
}
