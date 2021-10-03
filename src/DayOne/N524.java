package DayOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.jar.JarEntry;

/**
 * @author hdq
 * @create 2021-09-14 15:16
 */
public class N524 {
    public String findLongestWord(String s, List<String> dictionary) {
        List<String> all = new ArrayList<>();
        dictionary.sort((String a, String b) -> b.length() -a.length());
        for (String str :
                dictionary) {
            if (str.length() >s.length()){
                continue;
            }
            int j =0;
            for (int i = 0; i < s.length()&& j < str.length(); ) {
                if (s.charAt(i) == str.charAt(j)){
                    i++;
                    j++;
                }else {
                    i++;
                }
            }
            if (j >= str.length()){
                all.add(str);
            }
        }
        all.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()){
                    return o2.length() - o1.length();
                }else {
                    return o1.compareTo(o2);
                }
            }
        });
        if (all.size() > 0){
            return all.get(0);
        }
        return "";
    }

    public static void main(String[] args) {
        N524 n524 = new N524();
        List<String> strings = new ArrayList<>();
        strings.add("abe");
        strings.add("abc");
//        strings.add("c");
//        strings.add("d");
        System.out.println(n524.findLongestWord("abce", strings));
    }
}
