package NIUKEReal;

import java.util.HashMap;
import java.util.Map;

public class N3 {
    Map<Integer,Boolean> visited = new HashMap<>();
    public int Git (String[] matrix, int versionA, int versionB) {
        int len = matrix.length;
        ListNodeM[] allNodes = new ListNodeM[len];
        //  创建树节点
        for (int i = 0; i < len; i++) {
            allNodes[i] = new ListNodeM(i);
        }
        //  建树
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length(); j++) {
                if (matrix[i].charAt(j) != '0'){
                    allNodes[i].next.put(j,allNodes[j]);
                    allNodes[j].next.put(i,allNodes[i]);
                }
            }
        }
        //  求最短公公祖先
        visited.put(0,true);
        ListNodeM parent = findParent(versionA, versionB, allNodes[0]);
        return parent.val;
        // write code here
    }

    public ListNodeM findParent(int left, int right, ListNodeM root){
        if (root == null || root.val == left || root.val == right){
            return root;
        }
        ListNodeM res = null;
        int count = 0;
        for (Integer integer : root.next.keySet()) {
            if (!visited.containsKey(integer)){
                visited.put(integer,true);
                ListNodeM temp = findParent(left, right, root.next.get(integer));
                visited.remove(integer);
                if (temp != null) {
                    count++;
                    if (count == 1) {
                        res = temp;
                    }
                }
                if (count == 2) {
                    return root;
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"001","001","110"};
        System.out.println(new N3().Git(strs, 1, 1));
        System.out.println();
    }


    class ListNodeM {
        public    int val;
        public Map<Integer,ListNodeM> next;
        public ListNodeM() {}
        public ListNodeM(int val) {
            this.val = val;
            next = new HashMap<>();
        }
    }


}
