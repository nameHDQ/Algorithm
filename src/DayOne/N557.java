package DayOne;

/**
 * @author hdq
 * @create 2021-08-22 12:59
 */
public class N557 {
    public String reverseWords(String s) {
        char[]  cstr = s.toCharArray();
        for (int i = 0; i <s.length()-1 ;) {
            int next = i+1;
            for (int j = i+1; j <s.length() ; j++) {
                if (cstr[j] == ' '){
                    next = j-1;
                    break;
                }
                if (j==s.length()-1){
                    next = j;
                    break;
                }
            }
            i = i+next+1;
            for (int j =i ; j < next;j++,next-- ) {
                char temp = cstr[j];
                cstr[j] = cstr[next];
                cstr[next] = temp;
            }

        }
        String s1 = new String(cstr);
        return s1;
    }

    public static void main(String[] args) {
        N557 n557 = new N557();
        System.out.println(n557.reverseWords("Let's take LeetCode contest"));
    }
}
