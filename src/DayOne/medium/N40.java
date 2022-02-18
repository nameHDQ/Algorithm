package DayOne.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hdq
 * @create 2021-12-13 11:38
 */
public class N40 {
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> temp = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, target);
        return res;
    }
    public void dfs(int[] candidates, int idx ,int target){
        //是否满足结果
        if (target == 0){
            res.add(new LinkedList<>(temp));
            return;
        }
        for (int i = idx; i < candidates.length ; i++) {
            //限制了从前往后选 ，只能从后往前选 所以只有一种
            if(i > idx && candidates[i] == candidates[i-1]) continue;
            if (target - candidates[i] >=0){
                temp.add(candidates[i]);
                dfs(candidates,i+1, target-candidates[i]);
                temp.remove(temp.size()-1);
            }else {
                break;
            }
        }
    }
}
