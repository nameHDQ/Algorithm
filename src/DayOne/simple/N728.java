package DayOne.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hdq
 * @create 2022-03-31 12:21
 */
public class N728 {
    public List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (i % 10 == 0) {
                continue;
            }
            if (i < 10){
                list.add(i);
                continue;
            }

            int temp = i;
            while (temp > 0) {
                int num = temp % 10;
                if (num == 0 || i % num != 0) {
                    break;
                }
                temp = temp / 10;
                if (temp == 0) {
                    list.add(i);
                }
            }
        }
        return list;
    }
}
