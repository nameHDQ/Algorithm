package DayOne.simple;

public class N28 {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")){
            return 0;
        }
        boolean contains = haystack.contains(needle);
        if (!contains){
            return -1;
        }
        int hStart = 0;
        int nStart = 0;
        while (nStart < needle.length() && hStart < haystack.length()){

            if (haystack.charAt(hStart) == needle.charAt(nStart)) {
                hStart++;
                nStart++;
            }else {
                hStart = hStart - nStart + 1;
                nStart = 0;
            }
        }
        return nStart == needle.length() ? hStart - nStart : -1;
    }

    public static void main(String[] args) {
        new N28().strStr("hello", "ll");
    }
}
