package DayOne;

import java.util.Arrays;

/**
 * @author hdq
 * @create 2021-08-26 10:57
 */
public class N881 {
    public int numRescueBoats(int[] people, int limit) {
        if (people.length == 1){
            return 1;
        }
        int totoal = 0;
        Arrays.sort(people);
        int light = 0,heavy = people.length-1;
        while (light <= heavy){
            if (people[light]+people[heavy]<=limit){
                light++;
            }
            heavy--;
            totoal++;
        }
        return totoal;
    }

    public static void main(String[] args) {
        N881 n881 = new N881();
        int[] people = {5,1,4,2};
        System.out.println(n881.numRescueBoats(people, 6));
    }
}
