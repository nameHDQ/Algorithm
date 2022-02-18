package DayOne.simple;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @author hdq
 * @create 2021-12-02 10:24
 */
public class N506 {
    public String[] findRelativeRanks(int[] score) {
        int[][] scoreAndIndex = new int[score.length][2];
        for (int i = 0; i < score.length; i++) {
            scoreAndIndex[i][0] = score[i];
            scoreAndIndex[i][1] = i;
        }
        List<int[]> collect = Arrays.stream(scoreAndIndex).sorted((score1, score2) -> {
            return score2[0] - score1[0];
        }).collect(Collectors.toList());
        collect.forEach((co)->{
            System.out.println(co[0]+"  "+co[1]);
        });
        String[] str = new String[score.length];
        for (int i = 0; i < str.length; i++) {
            if (i == 0){
                str[collect.get(i)[1]] = "Gold Medal";
            }else if (i == 1){
                str[collect.get(i)[1]] = "Silver Medal";
            }else if (i == 2){
                str[collect.get(i)[1]] = "Bronze Medal";
            }else {
                str[collect.get(i)[1]] = String.valueOf(i+1);
            }
        }
        return str;
    }

    public static void main(String[] args) {
        N506 n506 = new N506();
        int[] ar = {5,4,3,2,1};
        String[] relativeRanks = n506.findRelativeRanks(ar);
        for (String relativeRank : relativeRanks) {
            System.out.println(relativeRank);
        }
    }
}
