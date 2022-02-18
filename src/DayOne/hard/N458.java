package DayOne.hard;

/**
 * @author hdq
 * @create 2021-11-25 11:50
 */
public class N458 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int times = minutesToTest/minutesToDie;
        int base = times+1;

        int temp =(int) Math.ceil(Math.log(buckets)/Math.log(base));


        return temp;
    }

    public static void main(String[] args) {
        N458 n458 = new N458();
        System.out.println(n458.poorPigs(4 , 15, 30));
    }
}
