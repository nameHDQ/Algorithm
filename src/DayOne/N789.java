package DayOne;

/**
 * @author hdq
 * @create 2021-08-22 12:18
 */
public class N789 {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int[] source = {0,0};
        int dis = TwoDistance(source,target);
        for (int[] ghost:ghosts){
            int gdis = TwoDistance(ghost,target);
            if (dis >= gdis){
                return false;
            }
        }

        return true;
    }
    public int TwoDistance(int[] source,int[] target){
        return Math.abs(target[0] - source[0]) +Math.abs(target[1] - source[1]);
    }
}
