package DayOne.medium;

/**
 * @author hdq
 * @create 2021-11-17 16:37
 */
public class N318 {
    public int maxProduct(String[] words) {
        int max = 0;
        for (int i = 0; i < words.length-1; i++) {
            for (int j = i+1; j <words.length ; j++) {
                if (isJoin(words[i].toCharArray(),words[j].toCharArray())){
                    max = Math.max(max, words[i].length()*words[j].length());
                }
            }
        }
        return max;
    }
    public boolean isJoin(char[] str1,char[] str2){
        boolean[] flag = new boolean[26];
        for (char c : str1) {
            flag[c-'a'] = true;
        }
        for (char c : str2) {
            if (flag[c-'a']){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        N318 n318 = new N318();
        String[] strs  = {"abcw","baz","foo","bar","xtfn","abcdef"};
        System.out.println(n318.maxProduct(strs));
    }
}
