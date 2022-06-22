package DayOne.simple;

/**
 * @author hdq
 * @create 2022-02-23 9:17
 */
public class N917 {
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length-1;
        while (start < end) {
            while (start < end && !Character.isLetter(chars[start])) {
                start++;
            }
            while (start < end && !Character.isLetter(chars[end])) {
                end--;
            }
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        N917 n917 = new N917();
        System.out.println(n917.reverseOnlyLetters("a-bC-dEf-ghIj"));
    }
}
