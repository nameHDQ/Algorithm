package DayOne.simple;

/**
 * @author hdq
 * @create 2022-04-21 8:39
 */
public class N824 {
    public String toGoatLatin(String sentence) {
        String y = "aeiouAEIOU";
        String[] splits = sentence.split(" ");
        String res = "";
        int count = 0;
        for (String split : splits) {
            count++;
            if (y.contains(split.charAt(0) + "")) {
                split += "ma";
            }else {
                split = split.substring(1) + split.charAt(0) + "ma";
            }
            for (int i = 0; i < count ; i++) {
                split += "a";
            }
            res += split + " ";
        }
        if (res.charAt(res.length() - 1) == ' ') {
            return res.substring(0, res.length() - 1);
        }else {
            return res;
        }
    }
}
