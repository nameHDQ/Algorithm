package DayOne.simple;

/**
 * @author hdq
 * @create 2021-12-01 11:52
 */
public class N1446 {
    public int maxPower(String s) {
        int temLen = 1;
        int maxLen = 1;
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)){
                temLen++;
                if (temLen > maxLen){
                    maxLen = temLen;
                }
            }else {
                temLen = 1;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        N1446 n1446 = new N1446();
        System.out.println(n1446.maxPower("abbcccddddeeeeedcba"));
    }
}
