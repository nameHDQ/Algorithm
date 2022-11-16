package DayOne.medium;

import java.util.*;

public class N77 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        Stack<Integer> temp = new Stack<>();
        for (int i = 1; i <= n; i++) {

            temp.push(i);
            backTrack(1, k, temp, i, n);
            temp.pop();
        }

        return res;
    }

    public void backTrack(int count, int k, Stack<Integer> temp, int curNode, int n){
        if (count == k){
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = curNode + 1; i <= n; i++) {
            temp.push(i);
            backTrack(count + 1, k, temp, i, n);
            temp.pop();
        }
    }

    public static void main(String[] args) {
        new N77().combine(4,2);
    }
}
