package DayOne.medium;

import java.util.ArrayList;
import java.util.List;

public class N95 {
    List<TreeNode> rs = new ArrayList<>();
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> treeNodes = dfs(1, n);
        return treeNodes;
    }

    public List<TreeNode> dfs(int start, int end){
        List<TreeNode> temp = new ArrayList<>();
        if (start > end){
            temp.add(null);
            return temp;
        }
        if (start == end){
            TreeNode root = new TreeNode(start);
            temp.add(root);
            return temp;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftRoots = dfs(start, i - 1);
            List<TreeNode> rightRoots = dfs(i + 1, end);
            for (TreeNode leftRoot : leftRoots) {
                for (TreeNode rightRoot : rightRoots) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftRoot;
                    root.right = rightRoot;
                    temp.add(root);
                }
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        new N95().generateTrees(3);
    }
}
