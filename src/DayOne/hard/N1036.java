package DayOne.hard;



import java.util.*;

/**
 * @author hdq
 * @create 2022-01-11 10:37
 */
public class N1036 {
    // 在包围圈中
    static final int BLOCKED = -1;
    // 不在包围圈中
    static final int VALID = 0;
    // 无论在不在包围圈中，但在 n(n-1)/2 步搜索的过程中经过了 target
    static final int FOUND = 1;

    static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    //边界  网格大小为10^6 * 10^6
    static final int BOUNDARY = 1000000;
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (blocked.length < 2){
            return true;
        }
        Set<pair> blockHash = new HashSet<>();
        for (int[] block : blocked) {
            blockHash.add(new pair(block[0],block[1]));
        }
        int resut = check(blocked, source, target,blockHash);
        if (resut == FOUND){
            return true;
        }else if (resut == BLOCKED){
            return false;
        }else {
            resut = check(blocked, target, source, blockHash);
            return resut!=BLOCKED;
        }
    }
    public int check(int[][] blocked, int[] start, int[] finish,Set<pair> blockHash){
        int sx = start[0],sy = start[1];
        int fx = finish[0],fy = finish[1];
        int countdown = blocked.length * (blocked.length - 1) / 2;
        Queue<pair> queue = new ArrayDeque<>();
        Set<pair> visited = new HashSet<>();
        pair p =new pair(sx, sy);
        queue.add(p);
        visited.add(p);
        while (!queue.isEmpty()&&countdown>0){
            pair curPair = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dirs[i][0] + curPair.x;
                int ny = dirs[i][1] + curPair.y;
                pair newPair = new pair(nx, ny);
                if (nx >=0 && ny >=0 && nx < BOUNDARY && ny <BOUNDARY && !blockHash.contains(newPair)
                        && !visited.contains(newPair)){
                    if (nx == finish[0] && ny == finish[1]){
                        return FOUND;
                    }
                    countdown--;
                    visited.add(newPair);
                    queue.add(newPair);
                }
            }
        }
        if (countdown > 0){
            return BLOCKED;
        }
        return VALID;
    }
}
class pair{
    int x ;
    int y;

    public pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        pair pair = (pair) o;
        return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
