package DayOne.medium;
import DayOne.DataStruct.Node;


public class N116 {
    public Node connect(Node root) {
        if (root == null) return root;

        Node head = root;

        while (head.left != null){

            Node cur = head;

            while (cur != null){

                // 直接左边赋值
                cur.left.next = cur.right;

                // 如果cur 右边还有节点
                if (cur.next != null){
                    cur.right.next = cur.next.left;
                }
                // 右边的节点依次处理
                cur = cur.next;

            }
            // 下一层
            head = head.left;
        }
        return root;
    }
}
