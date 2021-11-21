package DayOne.simple;


import java.util.Iterator;
import java.util.List;


// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
public class N559 {
    int max_deep = 1;
    int temp_deep = 1;
    public int maxDepth(Node root) {
        dfs(root);
        return temp_deep;
    }
    public void dfs(Node root){
        int n = root.children.size();
        if (n == 0){
            return;
        }else {
            Iterator<Node> iterator = root.children.iterator();
            max_deep++;
            if (max_deep > temp_deep){
                temp_deep = max_deep;
            }
            while (iterator.hasNext()){
                dfs(iterator.next());
            }
            max_deep--;
        }
    }

    public static void main(String[] args) {
        N559 n559 = new N559();
    }
}
