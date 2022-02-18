package DayOne.simple;

/**
 * @author hdq
 * @create 2021-12-21 10:42
 */
public class N1154 {
    int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
    public int dayOfYear(String date) {
        String[] split = date.split("-");
        int year = Integer.valueOf(split[0]);
        int month = Integer.valueOf(split[1]);
        int day = Integer.valueOf(split[2]);
        int allDay = 0;
        if ((year%4==0&&year%100!=0)||(year%400==0)){
            months[1] = 29;
        }
        for (int i = 0; i < month-1; i++) {
            allDay+=months[i];
        }


        return allDay+day;
    }

    public static void main(String[] args) {
        N1154 n1154 = new N1154();
        System.out.println(n1154.dayOfYear("2019-01-09"));
    }
}
