package DayOne.simple;

public class N1758 {
    public int minOperations(String s) {

        char[] chars = s.toCharArray();
        if (chars.length == 1){
            return 0;
        }
        int res = 0;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (index % 2 == 0){
                if (chars[i] != '0'){
                    res ++;
                }

            }else {
                if (chars[i] != '1'){
                    res++;
                }

            }
            index++;
        }


        return Math.min(chars.length - res, res);
    }

    public static void main(String[] args) {
        new N1758().minOperations("10010100");
    }
}
