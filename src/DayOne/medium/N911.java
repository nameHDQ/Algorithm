package DayOne.medium;

import java.util.Arrays;

/**
 * @author hdq
 * @create 2021-12-11 11:40
 */
class TopVotedCandidate {
    int[] person = null;
    int[] times = null;
    public TopVotedCandidate(int[] persons, int[] times) {
        this.person = persons;
        this.times = times;

    }

    public int q(int t) {
        int[] hash = new int[500];
        int maxT = 0;
        int inx =0;
        for (int i = 0; i < times.length; i++) {
            if (times[i] <= t){
                hash[person[i]]++;
                if (hash[person[i]] >= maxT){
                    maxT = hash[person[i]];
                    inx = person[i];
                }
            }else {
                break;
            }
        }
        return inx;
    }
}
public class N911 {
    public static void main(String[] args) {
        int[] person = {0,0,0,0,1};
        int[] times = {0,6,39,52,75};
        TopVotedCandidate topVotedCandidate = new TopVotedCandidate(person, times);
        System.out.println(topVotedCandidate.q(99));
    }
}
