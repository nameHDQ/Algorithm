package DayOne.simple;

import java.util.*;

/**
 * @author hdq
 * @create 2022-03-10 10:05
 */
public class N589 {

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            list.add(node.val);
            for(int i = node.children.size() - 1; i >= 0; i--){
                stack.push(node.children.get(i));
            }
        }
        return list;
    }
    public void dfs(Node root, List<Integer> list){
        if(root == null) return;
        list.add(root.val);
        for(Node node : root.children){
            dfs(node, list);
        }
    }

    public static void main(String[] args) {
        new N589().preorder(null);
    }
}
