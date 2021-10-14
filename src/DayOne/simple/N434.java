package DayOne.simple;

/**
 * @author hdq
 * @create 2021-10-07 10:17
 */
public class N434 {
    public int countSegments(String s) {
        if (s.length() == 0){
            return 0;
        }
        boolean isChar = false;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ' '){
                isChar = true;
            }else {
                if (isChar){
                    if (s.charAt(i) == ' '){
                        count++;
                        isChar =false;
                    }
                }
            }
            if (s.length()-1 == i){
                if (isChar){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        N434 n434 = new N434();
        System.out.println(n434.countSegments(
                ",,,Hello,,,,my name is John,, a, "));
    }
}
