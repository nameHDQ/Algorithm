package weekcmplication.week311;

public class N1 {
    public int smallestEvenMultiple(int n) {

        if (n <= 2) return n;

        if (n %2 != 0) return n * 2;
        else return n;
    }
}
