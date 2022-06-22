package DayOne.medium;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author hdq
 * @create 2022-05-22 9:49
 */
public class N464 {
    boolean result = false;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) return true;
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false;
        int[] state = new int[maxChoosableInteger + 1];
        return backtraceWitMemo(state, desiredTotal, new HashMap<String, Boolean>());
    }
    private boolean backtraceWitMemo(int[] state, int desiredTotal, HashMap<String, Boolean> map) {
        String key = Arrays.toString(state);




        return false;
    }
}
