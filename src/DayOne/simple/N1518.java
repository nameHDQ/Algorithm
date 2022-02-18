package DayOne.simple;

/**
 * @author hdq
 * @create 2021-12-17 10:20
 */
public class N1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = numBottles;
        while (numBottles >=numExchange){
            int temp = numBottles/numExchange;
            total +=temp;
            numBottles = temp + numBottles%numExchange;
        }


        return total;
    }

    public static void main(String[] args) {
        N1518 n1518 = new N1518();
        System.out.println(n1518.numWaterBottles(5 , 6));
    }
}
