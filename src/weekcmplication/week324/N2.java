package weekcmplication.week324;

import com.sun.javafx.util.TempState;

import java.util.HashMap;
import java.util.Map;

public class N2 {
    Map<Integer, Integer> map = new HashMap<>();
    public int smallestValue(int n) {
        int start = 2;
        int temSum = 0;
        while (!isPrem(n)) {
            int temp = n;
            start = 2;
            temSum = 0;
            while (start * start <= temp){
                while (temp % start == 0){
                    temSum += start;
                    temp /= start;
                }
                start++;
                if (temSum == n){
                    return temSum;
                }
                if (temp >= 2 && isPrem(temp)){
                    temSum += temp;
                    break;
                }
            }
            n = temSum;
        }
        return n;
    }
    public boolean consistPrem(int num){
        if (isPrem(num) || map.containsKey(num)){
            return true;
        }
        while (!isPrem(num)){
            for (int i = 2; i < num; i++) {
                if (num % i == 0 && consistPrem(i) && consistPrem(num / i)){
                    map.put(i, 1);
                    map.put(num / i, 1);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isPrem(int num){
        if (map.containsKey(num)) return true;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new N2().smallestValue(15));
    }
}
