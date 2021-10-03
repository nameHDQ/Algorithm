package week.weekspecial.sp2021autom;

/**
 * @author hdq
 * @create 2021-09-11 15:41
 */
public class N1 {
    public int minimumSwitchingTimes(int[][] source, int[][] target) {
        int count = 0;
        int[] dp1 = new int[10001];
        int[] dp2 = new int[10001];
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[0].length; j++) {
                dp1[source[i][j]]++;
                dp2[target[i][j]]++;
            }
        }
        for (int i = 1; i < dp1.length; i++) {
            if (dp1[i] >= dp2[i]){
                count += dp1[i] - dp2[i];
            }
        }
       return count;
    }

    public static void main(String[] args) {
        N1 n1 = new N1();
        int[][] source = {{1,2,3},{3,4,5}};
        int[][]target = {{1,3,5},{2,3,4}};
        System.out.println(n1.minimumSwitchingTimes(source, target));
    }
}
