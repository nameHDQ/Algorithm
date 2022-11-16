package DayOne.simple;

import jdk.nashorn.internal.ir.IfNode;

import java.util.HashMap;
import java.util.Map;

public class N1790 {
    public boolean areAlmostEqual(String s1, String s2) {

        int count = 0;
        int[] idx = new int[2];
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)){
                if (count == 2) return false;
                idx[count] = i;
                count++;

            }
        }
        if (count == 0) return true;
        if (count == 1){
            return false;
        }

        if (s1.charAt(idx[0]) != s2.charAt(idx[1]) || s2.charAt(idx[0]) != s1.charAt(idx[1])){
            return false;
        }

        return true;
    }
}
