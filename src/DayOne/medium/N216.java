package DayOne.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class N216 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {

        Stack<Integer> temp = new Stack<>();
        int sum = 0;
        for (int i = 1; i <= 9; i++) {

            temp.push(i);
            backTrack(1, k, temp, i, n,i);
            temp.pop();
        }

        return res;
    }
    public void backTrack(int count, int k, Stack<Integer> temp, int curNode, int n, int sum){
        if (count == k){
            if (sum == n){
                res.add(new ArrayList<>(temp));
            }
            return;
        }

        for (int i = curNode + 1; i <= 9; i++) {
            if (sum + i > n) {
                continue;
            }
            temp.push(i);
            backTrack(count + 1, k, temp, i, n, sum + i);
            temp.pop();
        }
    }
}
