package DayOne.simple;

public class N541 {
    public String reverseStr(String s, int k) {

        int len = s.length();
        int start = 0;
        StringBuilder res= new StringBuilder();
        while (start < len){

            StringBuilder sb = new StringBuilder();

            int first = (start + k) > len ? len : (start + k);
            int second = (start + 2 * k) > len ? len : start + 2 * k;

            sb.append(s.substring(start, first));
            res.append(sb.reverse());

            if (first < second) {
                res.append(s.substring(first, second));
            }
            start += 2 * k;
        }

        return res.toString();
    }

    public static void main(String[] args) {
        new N541().reverseStr("abcde", 2);
    }
}
