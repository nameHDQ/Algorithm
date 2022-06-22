package competition.spring2022;

import DayOne.DataStruct.Node;

import java.util.*;

/**
 * @author hdq
 * @create 2022-04-16 15:47
 */
public class N3 {
    public int getNumber(TreeNode root, int[][] ops) {
        // 动态数组存有序数据
        Map<Integer,Integer> map = new HashMap();
        dfs(root, map);
        for (int[] op : ops) {
            // 染红 节点值设为-1
            if (op[0] == 1) {
                int left = op[1];
                int right = op[2];
                while (left <= right) {
                    if (map.containsKey(left)) {
                        map.put(left, -1);
                    }
                    left++;
                }
            }else {
                // 染蓝 节点值设为-2
                int left = op[1];
                int right = op[2];
                while (left <= right) {
                    if (map.containsKey(left)) {
                        map.put(left, -2);
                    }
                    left++;
                }
            }
        }
        int res = 0;
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            if (map.get(key) == -1) {
                res++;
            }
        }
        return res;
    }
    private void dfs(TreeNode root, Map<Integer,Integer> map) {
        if (root == null) {
            return;
        }
        dfs(root.left, map);
        map.put(root.val, 0);
        dfs(root.right, map);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n4.left = n2;
        n2.left = n1;
        n4.right = n7;
        n7.left = n5;
        n5.right = n6;
        int[][] ops = {{0,2,2},{1,1,5},{0,4,5},{1,5,7} };
        System.out.println(new N3().getNumber(n4, ops));
    }

}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

