package DayOne.simple;

public class N69 {
    public int mySqrt(int x) {

        long right = x;
        long left = 1;

        while (left <= right){
            long mid = left + ((right - left) >> 1) ;
            if (mid * mid == x){
                return (int) mid;
            }
            if (mid * mid > x){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return (int) left -1 ;
    }

    public static void main(String[] args) {
        System.out.println(new N69().mySqrt(24));
    }
}
