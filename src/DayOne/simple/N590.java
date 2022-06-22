package DayOne.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hdq
 * @create 2022-03-12 11:43
 */
public class N590 {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        dfs(root,list);
        return list;
    }
    public void dfs(Node root,List<Integer> list){
        if(root==null) return ;
        for (Node node : root.children) {
            dfs(node,list);
        }
        list.add(root.val);
    }
}
