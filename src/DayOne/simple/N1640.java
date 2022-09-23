package DayOne.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class N1640 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            index.put(pieces[i][0], i);
        }
        for (int i = 0; i < arr.length;) {
            if (!index.containsKey(arr[i])){
                return false;
            }
            Integer loc = index.get(arr[i]);
            int length = pieces[loc].length;
            for (int j = 0; j < length; j++) {
                if (arr[i + j] != pieces[loc][j]){
                    return false;
                }
            }
            i += length;
        }
        return true;
    }
}
