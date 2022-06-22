package DayOne.medium;

import java.util.Map;
import java.util.Stack;

/**
 * @author hdq
 * @create 2022-04-20 9:49
 */
public class N388 {
    public int lengthLongestPath(String input) {
        String[] splits = input.split("\n");
        Map<Integer, Integer> map = new java.util.HashMap<>();
        int max = 0;
        for (String s : splits) {
            int level = 0;
            for (int i = 0; i < s.length(); i++) {
                // 计算当前是第几层
                if (s.charAt(i) == '\t'){
                    level++;
                }
            }
            map.put(level,s.length()-level + map.getOrDefault(level-1,0));
            if (s.contains(".")){
                max = Math.max(max,map.get(level) + level);
            }


        }
        return max;
    }

    public static void main(String[] args) {
        String string = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        N388 n388 = new N388();
        System.out.println(n388.lengthLongestPath(string));
    }
}
