package DayOne;

/**
 * @author hdq
 * @create 2021-09-07 10:26
 */
public class N1221 {
    public int balancedStringSplit(String s) {
        if (s.length() == 0){
            return 0;
        }
        int maxnum = 0;
        for (int i = 0; i < s.length()-1; i++) {
            int countr = 0;
            int countl = 0;
            if (s.charAt(i) == 'R'){
                countr++;
            }else {
                countl++;
            }
            for (int j = i+1; j <s.length() ; j++) {
                if (s.charAt(j) == 'R'){
                    countr++;
                }else {
                    countl++;
                }
                if (countl ==countr){
                    if (i == 0 && j == s.length()-1){
                        return 1;
                    }
                    maxnum++;
                    i = j+1;
                }
            }
        }
        return maxnum;
    }

    public static void main(String[] args) {
        N1221 n1221 = new N1221();
        System.out.println(n1221.balancedStringSplit("RLRRRLLRLL"));
    }

}
