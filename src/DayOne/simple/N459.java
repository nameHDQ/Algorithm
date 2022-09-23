package DayOne.simple;

import DayOne.medium.N45;

public class N459 {
    public boolean repeatedSubstringPattern(String s) {

        for (int i = 1; i * 2 <= s.length(); i++) {
            if (s.length() % i == 0){
                boolean match = true;
                for (int j = i; j < s.length(); j++) {
                    if (s.charAt(j) == s.charAt(j - i)){
                        continue;
                    }else {
                        match = false;
                        break;
                    }
                }
                if (match){
                    return true;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new N459().repeatedSubstringPattern("ababba"));
    }
}
