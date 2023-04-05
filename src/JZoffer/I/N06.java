package JZoffer.I;

import Utils.ListNode;

import java.util.ArrayList;
import java.util.List;

public class N06 {
    public int[] reversePrint(ListNode head) {
        List<Integer> res = new ArrayList<>();

        dfs(head, res);
        int[] resNums = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resNums[i] = res.get(i);
        }
        return resNums;
    }

    public void dfs(ListNode root, List<Integer> res){
        if (root == null){
            return;
        }
        dfs(root.next, res);
        res.add(root.val);
    }
}
