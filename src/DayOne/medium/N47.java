package DayOne.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hdq
 * @create 2021-12-13 10:19
 */
public class N47 {
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> temp = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] state = new boolean[nums.length];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (state[i]||i > 0  && nums[i] == nums[i - 1] && !state[i - 1]){
                continue;
            }
            state[i] = true;
            temp.add(nums[i]);
            dfs(state,1, nums);
            temp.remove(temp.size()-1);
            state[i] = false;
        }

        return res;
    }
    public void dfs(boolean[] state,int curLen,int[] nums){
        if (curLen == nums.length){
            res.add(new LinkedList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length ; i++) {
            //限制了从前往后选 ，只能从后往前选 所以只有一种
            if (state[i] ||(i > 0  && nums[i] == nums[i - 1] && !state[i - 1])){
                continue;
            }
            if (state[i] == false){
                state[i] = true;
                temp.add(nums[i]);
                dfs(state,curLen+1, nums);
                temp.remove(temp.size()-1);
                state[i] = false;
            }
        }
    }
}
