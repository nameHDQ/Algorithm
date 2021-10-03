package DayOne;

/**
 * @author hdq
 * @create 2021-08-17 19:24
 */
public class N551 {
    public boolean checkRecord(String s) {
        int countA = 0;
        int countL = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A'){
                countA++;
            }
            if (countA >= 2){
                return false;
            }
            if (s.charAt(i) != 'L'){
                countL = 0;
            }
            if (s.charAt(i) == 'L'){
                countL++;
            }
            if (countL >= 3){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        N551 n551 = new N551();
        System.out.println(n551.checkRecord("AA"));
    }
}
