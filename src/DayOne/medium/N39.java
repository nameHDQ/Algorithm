package DayOne.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hdq
 * @create 2021-12-13 10:48
 */
public class N39 {

    List<Integer> temp = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, 0, target);
        return res;
    }
    public void dfs(int[] candidates, int idx ,int target){
        if (idx == candidates.length){
            return;
        }
        //是否满足结果
        if (target == 0){
            res.add(new LinkedList<>(temp));
            return;
        }
        //跳过当前数据
        dfs(candidates, idx+1, target);
        //依然选择当前数据
        if (target - candidates[idx] >=0){
            temp.add(candidates[idx]);
            dfs(candidates, idx,target - candidates[idx]);
            temp.remove(temp.size()-1);
        }
    }
}
