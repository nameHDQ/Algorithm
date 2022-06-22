package DayOne.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hdq
 * @create 2022-05-03 11:22
 */
public class N937 {
    public String[] reorderLogFiles(String[] logs) {
        int n = logs.length;
        String[] res = new String[n];
        List<String> digit = new ArrayList<>();
        List<String> letter = new ArrayList<String>();
        int i = 0;
        // 先找出数字的
        for (String log : logs) {
            String[] split = log.split(" ", 2);
            if (split[1].charAt(0) >= '0' && split[1].charAt(0) <= '9') {
                digit.add(log);
            }else {
                letter.add(log);
            }
        }
        // 再排序
        letter.sort((s1, s2) -> {
            String[] split1 = s1.split(" ", 2);
            String[] split2 = s2.split(" ", 2);
            int cmp = split1[1].compareTo(split2[1]);
            if (cmp == 0) {
                // 内容相同，比较标识符
                cmp = split1[0].compareTo(split2[0]);
            }
            return cmp;
        });
        // 再拼接
        for (String s : letter) {
            res[i++] = s;
        }
        for (String s : digit) {
            res[i++] = s;
        }
        return res;
    }
}
