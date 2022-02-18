package DayOne.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hdq
 * @create 2021-12-12 13:21
 */
public class N78 {
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> temp = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0,nums);
        return null;
    }
    public void dfs(int len ,int[] nums){
        if (nums.length == len){
            res.add(new LinkedList<>(temp));
            return;
        }
        //选取这个节点
        temp.add(nums[len]);
        dfs(len+1,nums);
        //不选去当前节点
        temp.remove(temp.size()-1);
        dfs(len+1, nums);
    }
}
