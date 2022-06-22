package DayOne.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hdq
 * @create 2022-03-06 12:05
 */
public class N2100 {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> res = new ArrayList<>();
        int n = security.length;
        int[] predp = new int[n];
        int[] lasdp = new int[n];
        // 前缀和
        for (int i = 0; i < n; i++) {
            predp[i] = security[i];
            if (i > 0) {
                predp[i] += predp[i - 1];
            }
        }
        for (int i = n - 1; i >= 0 ; i++) {
            lasdp[i] = security[i];
            if (i < n - 1) {
                lasdp[i] += lasdp[i + 1];
            }
        }
        for (int i = 0; i < n; i++) {

        }
        return res;
    }
}
