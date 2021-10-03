package DayOne;

/**
 * @author hdq
 * @create 2021-08-21 12:34
 */
public class N443 {
    public int compress(char[] chars) {
        int count = 0;
        String str = "";
        if (chars.length == 1){
            return 1;
        }
        for (int i=0; i < chars.length - 1 ; i++) {
            if (i != chars.length-2){
                if (chars[i] == chars[i+1]){
                    count++;
                }else {
                    if (count == 0){
                        str += chars[i];
                    }else {
                        str += chars[i];
                        str += count+1;
                    }
                    count =0;
                }
            }else {
                if (chars[i] == chars[i+1]){
                    count++;
                    str += chars[i];
                    str += count+1;
                    break;
                }else {
                    if (count == 0){
                        str += chars[i];
                    }else {
                        str += chars[i];
                        str += count+1;
                    }
                    str += chars[i+1];
                    break;
                }
            }

        }
        for (int i = 0; i < str.length(); i++) {
            chars[i]=str.charAt(i);
        }
        return str.length();
    }

    public static void main(String[] args) {
        N443 n443 = new N443();
        char[] chars = {'a','b','b','c','c','c'};
        System.out.println(n443.compress(chars));

    }
}
