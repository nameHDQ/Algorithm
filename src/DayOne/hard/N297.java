package DayOne.hard;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class N297 {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return dfsCode(root,"");
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] split = data.split(",");
            List<String> ser = new ArrayList<>(Arrays.asList(split));
            return dfsDeCode(ser);
        }

        public String dfsCode(TreeNode root, String str){
            if (root == null){
                return str + "Null,";
            }else {
                str += root.val + ",";
                str = dfsCode(root.left, str);
                str = dfsCode(root.right, str);
                return str;
            }
        }
        public TreeNode dfsDeCode(List<String> str){
            if (str.get(0).equals("Null")){
                str.remove(0);
                return null;
            }else {

                int val = Integer.parseInt(str.remove(0));
                TreeNode temp = new TreeNode(val);
                temp.left = dfsDeCode(str);
                temp.right = dfsDeCode(str);
                return temp;
            }
        }
    }
}
