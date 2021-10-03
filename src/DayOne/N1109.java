package DayOne;

/**
 * @author hdq
 * @create 2021-08-31 11:00
 */
public class N1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] answer = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            int start = bookings[i][0], end = bookings[i][1];
            for (int j = start; j <= end ; j++) {
                answer[j-1] +=bookings[i][2];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        N1109 n1109 = new N1109();
        int[][] bookings = {{1,2,10},{2,3,20},{2,5,25}};
        int[] ints = n1109.corpFlightBookings(bookings, 5);
        for (int i :
                ints) {
            System.out.println(i);
        }
    }
}
