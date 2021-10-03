package DayOne.simple;

/**
 * @author hdq
 * @create 2021-09-21 10:28
 */
public class N58 {
    public int lengthOfLastWord(String s) {

        String[] s1 = s.split(" ");
        for (int i = 0; i < s1.length; i++) {
            if (s1[s1.length-i-1].length() >0){

                return s1[s1.length-i-1].length();
//                System.out.println(s1[s1.length-i-1] +",");
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        N58 n58 = new N58();
        System.out.println(n58.lengthOfLastWord("luffy is still joyboy"));
    }
}
