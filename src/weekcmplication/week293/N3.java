package weekcmplication.week293;

import javax.xml.transform.Result;
import java.awt.font.FontRenderContext;

/**
 * @author hdq
 * @create 2022-05-15 11:34
 */
public class N3 {
    int maxLen=1;
    public int largestCombination(int[] candidates) {
        if (candidates.length == 1) {
            return 1;
        }
        int n = candidates.length;
        for (int i = 0; i < n; i++) {
            dfs(candidates, i,candidates[i],0);
        }


        return maxLen;
    }
    public void dfs(int[] candidates, int index,int preResult ,int count) {
        int temp = preResult & candidates[index];
        if (temp == 0) {
            return;
        }else {
            count++;
            if (count > maxLen) {
                maxLen = count;
            }
            for (int i = index + 1; i < candidates.length; i++) {
                dfs(candidates, i, temp, count);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {1};
        System.out.println(new N3().largestCombination(candidates));
    }
}
