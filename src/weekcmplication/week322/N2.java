package weekcmplication.week322;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class N2 {
    public long dividePlayers(int[] skill) {
        int sum = Arrays.stream(skill).sum();
        int len = skill.length;
        int avg = sum / (len / 2);
        Arrays.sort(skill);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < skill.length; i++) {
            map.put(skill[i], map.getOrDefault(skill[i], 0) + 1);
        }
        int count = 0;
        long res = 0;
        for (int i = 0; i < len; i++) {



            // 当前数使用过没有
            if (map.get(skill[i]) >=1){
                map.put(skill[i],map.get(skill[i]) - 1);
            }else {
                continue;
            }
            // 存在可加的数
            if (map.getOrDefault(avg - skill[i], 0) >= 1){
                map.put(avg - skill[i], map.get(avg - skill[i]) - 1);
                count++;
                res += (avg - skill[i]) * skill[i];
            }else {
                // 当前数无可加的数， 返回-1
                return -1;
            }
        }

        return count == (len / 2) ? res : -1;
    }
}
