package CodeTop;

public class N50 {
    public double myPow(double x, int n) {
        if (n == 0){
            return 1;
        }
        double half = myPow(x * x, n / 2);
        double one = myPow(x * x, n % 2);

        return half * one * x;
    }

}
