package DayOne.simple;

/**
 * @author hdq
 * @create 2021-10-15 9:23
 */
public class N38 {
    public String countAndSay(int n) {
        if (n == 1){
            return "1";
        }
        int num=1;
        String res = "";
        String str = String.valueOf(1);
        for (int i = 2; i <=n  ; i++) {
            char ch = str.charAt(0);
            String temp = "";
            for (int j = 1; j < str.length(); j++) {
                if (ch == str.charAt(j)){
                    num++;
                }else {
                    temp +=String.valueOf(num) + ch;
                    ch = str.charAt(j);
                    num = 1;
                }
            }
            temp +=String.valueOf(num) + ch;
            num = 1;
            res = temp;
            str = temp;
        }
        return res;
    }

    public static void main(String[] args) {
        N38 n38 = new N38();
        System.out.println(n38.countAndSay(5));
    }
}
