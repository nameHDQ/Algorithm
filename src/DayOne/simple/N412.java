package DayOne.simple;

import DayOne.medium.N29;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hdq
 * @create 2021-10-13 11:50
 */
public class N412 {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i%3 == 0 && i%5 == 0){
                list.add("FizzBuzz");
            }else if (i%3 == 0){
                list.add("Fizz");
            }else if (i%5 == 0){
                list.add("Buzz");
            }else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        N412 n412 = new N412();
        System.out.println(n412.fizzBuzz(15));
    }
}
