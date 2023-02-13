package weekcmplication.week322;

public class N1 {
    public boolean isCircularSentence(String sentence) {
        String[] strs = sentence.split(" ");

        int len = strs.length;
        int firstLen = strs[0].length();
        int lastLen = strs[strs.length - 1].length();

        if (strs[0].charAt(0) != strs[len - 1].charAt(lastLen - 1)){
            return false;
        }

        for (int i = 1; i < len; i++) {
            firstLen = strs[ i -1].length();
            lastLen = strs[i].length();
            if (strs[i - 1].charAt(firstLen - 1) != strs[i].charAt(0)){
                return false;
            }
        }
        return true;
    }
}
