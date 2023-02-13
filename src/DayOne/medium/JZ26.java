package DayOne.medium;

public class JZ26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        if (dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B)){
            return true;
        }else {
            return false;
        }
    }

    public boolean dfs(TreeNode rootA, TreeNode rootB){
        if (rootB == null) {
            return true;
        }
        if (rootA == null){
            return false;
        }
        if (rootA.val != rootB.val) return false;


        return  dfs(rootA.left, rootB.left)&&dfs(rootA.right, rootB.right);

    }
}
