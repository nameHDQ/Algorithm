package DayOne.simple;

/**
 * @author hdq
 * @create 2021-12-04 11:34
 */
public class N383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ran = new int[26];
        int[] mag = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            ran[ransomNote.charAt(i)-'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            mag[magazine.charAt(i)-'a']++;
        }
        for (int i = 0; i < ran.length; i++) {
            if (ran[i] > 0){
                if (ran[i] > mag[i]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        N383 n383 = new N383();
        String a ="aa";
        String b ="ab";
        System.out.println(n383.canConstruct(a, b));
    }
}
