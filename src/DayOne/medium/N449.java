package DayOne.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hdq
 * @create 2022-05-11 6:50
 */
public class N449 {
    static class Codec {
        List<TreeNode> list ;
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            bfs(root,sb);
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) {
                return null;
            }
            String[] split = data.split(",");
            if (split.length == 0) {
                return null;
            }
            int size = split.length;
            TreeNode root = new TreeNode(Integer.parseInt(split[0]));
            List<TreeNode> lastNode = new ArrayList<>();
            lastNode.add(root);
            int index = 1;
            int curSize = 0;
            while (index < size) {
                int lastSize = lastNode.size();
                for (; curSize < lastSize && index < size; curSize++) {
                    TreeNode node = lastNode.get(curSize);
                    if (node == null) {
                        continue;
                    }
                    if (split[index].equals("null")) {
                        node.left = null;
                    }else {
                        node.left = new TreeNode(Integer.parseInt(split[index]));
                        lastNode.add(node.left);
                    }
                    index++;
                    if (index >= size) {
                        break;
                    }
                    if (split[index].equals("null")) {
                        node.right = null;
                    }else {
                        node.right = new TreeNode(Integer.parseInt(split[index]));
                        lastNode.add(node.right);
                    }
                    index++;
                }
            }
            return root;
        }
        public void bfs(TreeNode root,StringBuilder sb) {
            if (root == null) {
                return;
            }
            list = new ArrayList<>();
            list.add(root);
            sb.append(root.val);
            int lastSize = list.size();
            int LastIndex = 0;
            while (lastSize > 0) {
                int curSize = 0;
                int size = list.size();
                for (; LastIndex < size ; LastIndex++) {
                    TreeNode node = list.get(LastIndex);
                    if (node == null) {
                        continue;
                    }
                    if (node.left != null) {
                        list.add(node.left);
                        curSize++;
                        sb.append("," + node.left.val);
                    }else {
                        list.add(null);
                        sb.append(",null");
                    }
                    if (node.right != null) {
                        list.add(node.right);
                        curSize++;
                        sb.append("," + node.right.val);
                    }else {
                        list.add(null);
                        sb.append(",null");
                    }
                }
                lastSize = curSize;
            }
        }
    }

    public static void main(String[] args) {
        N449 n449 = new N449();
        Codec codec = new Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(codec.deserialize(codec.serialize(root)));

    }
}
