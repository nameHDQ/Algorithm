package DayOne.simple;

/**
 * @author hdq
 * @create 2021-10-23 13:42
 */
public class N492 {
    public int[] constructRectangle(int area) {
        int[] target = {0,0};
        if (area == 0){
            return target;
        }
        for (int i = 1; i <= (int) Math.sqrt(area); i++) {
            if (area % i == 0){
                target[0] = area / i;
                target[1] = i;
            }
        }
        return target;
    }

    public static void main(String[] args) {
        N492 n492 = new N492();
        for (int i : n492.constructRectangle(3)) {
            System.out.println(i);
        }
    }
}
