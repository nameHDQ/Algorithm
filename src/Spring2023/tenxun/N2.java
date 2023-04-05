package Spring2023.tenxun;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class N2 {
    public static int res = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int N = Integer.parseInt(in.nextLine());
        Map<Character,Integer>[] maps = new Map[N];
        for (int i = 0; i < N; i++) {
            maps[i] = new HashMap<>();
            String str = in.nextLine();
            for (int j = 0; j < str.length(); j++) {
                maps[i].put(str.charAt(j), 1);
            }
        }
        int[] status = new int[26];
        dfs(maps,N, 0, status);
        System.out.println(res);
    }
    public static void dfs(Map<Character, Integer>[] maps, int level, int index, int[] status){
        if (level == index){
            res++;
            return;
        }
        for (Character character : maps[index].keySet()) {
            if (status[character - 'a'] == 0){
                status[character - 'a'] = 1;
                dfs(maps, level, index + 1, status);
                status[character - 'a'] = 0;
            }
        }
    }
//    3
//    ab
//            ca
//    ccb
}
