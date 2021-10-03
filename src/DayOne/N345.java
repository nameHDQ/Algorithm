package DayOne;

/**
 * @author hdq
 * @create 2021-08-19 11:56
 */
public class N345 {
    public String reverseVowels(String s) {
        char[] c ={'a','e','i','o','u','A','E','I','O','U'};
        char[] cstr = s.toCharArray();
        int[] indexs = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < c.length; j++) {
                if (s.charAt(i) == c[j]){
                    indexs[i] = 1;
                    break;
                }
            }
        }
        for (int i = 0,j = s.length()-1; i < j ;) {
            if (indexs[i] == 1 && indexs[j] == 1){
                char temp = cstr[i];
                cstr[i] = cstr[j];
                cstr[j] = temp;
                i++;
                j--;
            }
            if (indexs[i] != 1){
                i++;
            }
            if (indexs[j] != 1){
                j--;
            }

        }
        String s1 = new String(cstr);
        return s1;
    }

    public static void main(String[] args) {
        N345 n345 = new N345();
        System.out.println(n345.reverseVowels("leetcode"));
    }
}
