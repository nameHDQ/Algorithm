package DayOne.simple;

/**
 * @author hdq
 * @create 2021-11-13 10:37
 */
public class N520 {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1){
            return true;
        }
        boolean first =false;
       int lownum = 0;
       int upnum = 0;
        for (int i = 0; i < word.length(); i++) {
            if (i == 0){
                if (word.charAt(i)>='A' && word.charAt(i) <='Z'){
                    first = true;
                }
            }else {
                if (word.charAt(i)>='a' && word.charAt(i) <='z'){
                    lownum++;
                }else {
                    upnum++;
                }
            }

        }
        if (first){
            if (lownum == word.length()-1 ||upnum == word.length()-1){
                return true;
            }else {
                return false;
            }
        }else {
            if (lownum == word.length()-1){
                return true;
            }else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        N520 n520 = new N520();
        System.out.println(n520.detectCapitalUse("f"));
    }
}
