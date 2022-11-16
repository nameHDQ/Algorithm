package DayOne.medium;

import java.util.ArrayList;
import java.util.List;

public class N886 {
    public boolean possibleBipartition(int n, int[][] dislikes) {

        int[] color = new int[n + 1];
        List<Integer>[] gMap = new List[n + 1];
        for (int i = 0; i < gMap.length; i++) {
            gMap[i] = new ArrayList<>();
        }
        for (int[] dislike : dislikes) {
            gMap[dislike[0]].add(dislike[1]);
            gMap[dislike[1]].add(dislike[0]);
        }
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0 && !dfs(gMap, 1, color, i)){
                return false;
            }

        }
        return true;
    }

    public boolean dfs(List<Integer>[] map,int nowColor,int[] color,  int cur){
        color[cur] = nowColor;
        for (Integer next : map[cur]) {
            if (color[next] != 0 && color[next] == nowColor){
                return false;
            }
            if (color[next] == 0 && !dfs(map, 3 ^ nowColor, color, next)){
                return false;
            }
        }
        return true;
    }
}
