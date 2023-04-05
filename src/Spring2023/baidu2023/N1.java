package Spring2023.baidu2023;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class N1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        while (n-- > 0) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            Map<Character, Integer> map = new HashMap<>();
            String str = in.nextLine();
            if (str.length() != 5){
                System.out.println("No");
                continue;
            }
            for (int i = 0; i < str.length(); i++) {
                map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
            }
            String temp = "Baidu";
            boolean flag = true;
            for (int i = 0; i < temp.length(); i++) {
                if (map.getOrDefault(temp.charAt(i), 0) != 1){
                    flag = false;
                    break;
                }
            }
            if (flag){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }

        }
    }
}
