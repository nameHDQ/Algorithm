package JZoffer.I;

import Utils.Node;

import java.util.HashMap;
import java.util.Map;

public class N35 {
    public Node copyRandomList(Node head) {

        Map<Node, Node> isHas = new HashMap<>();
        Node curHead = new Node(head.val);
        isHas.put(head, curHead);
        Node random = new Node(head.random.val);
        curHead.random = random;
        isHas.put(head.random, curHead.random);
        Node pre = curHead;
        while (head.next != null){
            head = head.next;
            if (!isHas.containsKey(head)){
                Node temp = new Node(head.val);
                pre.next = temp;
                isHas.put(head, temp);
            }else {
                pre.next = isHas.get(head);
            }
            if (!isHas.containsKey(head.random)){
                Node temp = new Node(head.random.val);
                pre.next.random = temp;
                isHas.put(head, temp.random);
            }else {
                pre.next.random = isHas.get(head.random);
            }
            pre = pre.next;
        }
        return curHead;
    }
}
