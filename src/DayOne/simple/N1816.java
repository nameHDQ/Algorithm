package DayOne.simple;

/**
 * @author hdq
 * @create 2021-12-06 11:06
 */
public class N1816 {
    public String truncateSentence(String s, int k) {
        String[] s1 = s.split(" ");
        String str = "";
        for (int i = 0; i < k && i < s1.length; i++) {
            if (i!= k-1 && i !=s1.length-1){
                str+=s1[i] + " ";
            }else {
                str+=s1[i];
            }

        }

        return str;
    }

    public static void main(String[] args) {
        N1816 n1816 = new N1816();
        String str = "chopper";
        System.out.println(n1816.truncateSentence(str, 1));
    }
}
