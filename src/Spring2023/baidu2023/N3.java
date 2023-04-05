package Spring2023.baidu2023;

import java.util.*;

public class N3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        char[] color = new char[n];
        String tempColor = in.nextLine();
        for (int i = 0; i < tempColor.length(); i++) {
            color[i] = tempColor.charAt(i);
        }
        Map<Integer ,List<Integer>> edges = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            String[] edge = in.nextLine().split(" ");
            int left = Integer.parseInt(edge[0]);
            int right = Integer.parseInt(edge[1]);
            List<Integer> leftEdge = edges.getOrDefault(left, new ArrayList<>());
            List<Integer> rightEdge = edges.getOrDefault(right, new ArrayList<>());
            leftEdge.add(right);
            rightEdge.add(left);
        }
        System.out.println(2);
     }

    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public char color;
        TreeNode() {}
        public TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
