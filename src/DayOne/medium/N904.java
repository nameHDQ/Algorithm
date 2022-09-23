package DayOne.medium;

import java.util.HashMap;
import java.util.Map;

public class N904 {

    public int totalFruit(int[] fruits) {

        int left = 0;
        int las_index = 0;
        int maxLen = 0;
        int tempLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < fruits.length; i++) {
            map.put(fruits[i],1);
            if (map.size() <= 2){
                tempLen = i - left + 1;
                if (tempLen > maxLen) {
                    maxLen = tempLen;
                }
            }else {
                map.clear();
                map.put(fruits[las_index],1);
                map.put(fruits[i], 1);
                left = las_index;
            }
            if (fruits[las_index] == fruits[i]){
                continue;
            }
            las_index = i;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {3,3,3,1,2,1,1,2,3,3,4};
        new N904().totalFruit(nums);
    }
}
