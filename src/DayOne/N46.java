package DayOne;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hdq
 * @create 2021-08-29 13:12
 */
public class N46 {
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        int[] state = new int[nums.length];
        dfs(state,nums);
        return ans;
    }

    public void dfs(int[] state,int[] nums){
        if (temp.size() == nums.length){
            List<Integer> now = new LinkedList<>();
            now.addAll(temp);
            ans.add(now);
            return;
        }
        for (int j = 0; j < state.length; j++) {
            if (state[j] ==0){
                state[j] = 1;
                temp.add(nums[j]);
                dfs(state,nums);
                temp.remove(temp.size()-1);
                state[j] = 0;
            }
        }

    }

    public static void main(String[] args) {
        N46 n46 = new N46();
        int[] nums = {0,1};
        List<List<Integer>> permute = n46.permute(nums);
        for (List<Integer> l :
                permute) {
            for (int i :
                    l) {
                System.out.println(i);
            }
        }
    }
}
