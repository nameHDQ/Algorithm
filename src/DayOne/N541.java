package DayOne;

/**
 * @author hdq
 * @create 2021-08-20 11:06
 */
public class N541 {
    public String reverseStr(String s, int k) {
        int isReverse = 0;
        char[] cstr = s.toCharArray();
        if (s.length() <= k){
            for (int i = 0 , j = s.length()-1; i < j ; i++,j--) {
                char temp = cstr[i];
                cstr[i] = cstr[j];
                cstr[j] = temp;
            }
            String s1 = new String(cstr);
            return s1;
        }
        for (int i = 0; i < s.length(); ) {
                if (s.length() -i >k-1){
                    for (int j = 0, l=k-1; j < l ; j++,l--) {
                        char temp = cstr[i+j];
                        cstr[i+j] = cstr[i+l];
                        cstr[i+l] = temp;
                    }
                }else {
                    for (int j = 0, l=s.length()-i-1; j < l ; j++,l--) {
                        char temp = cstr[i+j];
                        cstr[i+j] = cstr[i+l];
                        cstr[i+l] = temp;
                    }
                    break;
               }
                i =i+2*k;

        }
        String s2 = new String(cstr);
        return s2;
    }

    public static void main(String[] args) {
        N541 n541 = new N541();
        System.out.println(n541.reverseStr("abcdefg", 3));
    }
}
