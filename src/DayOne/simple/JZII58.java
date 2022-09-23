package DayOne.simple;

public class JZII58 {
    public String reverseLeftWords(String s, int n) {
        String substring1 = s.substring(0, n);
        String substring2 = s.substring(n, s.length());
        return substring2 + substring1;
    }
}
