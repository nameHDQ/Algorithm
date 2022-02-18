package DayOne.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hdq
 * @create 2021-11-27 9:18
 */
//class Solution {
//    int[][] nowMN = null;
//    public Solution(int m, int n) {
//        nowMN = new int[m][n];
//    }
//
//    public int[] flip() {
//        int num0 = 0;
//        Map<Integer,Integer[]> map = new HashMap<>();
//        for (int i = 0; i < nowMN.length; i++) {
//            for (int j = 0; j < nowMN[0].length; j++) {
//                if (nowMN[i][j] == 0){
//                    num0++;
//                    map.put(num0, new Integer[]{i,j});
//                }
//            }
//        }
//        int ran = (int) (Math.random()*num0)+1;
//        nowMN[(map.get(ran)[0])][(map.get(ran)[1])] = 1;
//        int[] re = {map.get(ran)[0],map.get(ran)[1]};
//        return re;
//    }
//
//    public void reset() {
//        nowMN = new int[nowMN.length][nowMN[0].length];
//    }
//}
public class N519 {
    public static void main(String[] args) {
        System.out.println((int) (Math.random()*10));
    }
}
