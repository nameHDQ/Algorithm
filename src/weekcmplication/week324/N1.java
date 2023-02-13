package weekcmplication.week324;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class N1 {
    public int similarPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            Set<Character> set = new HashSet<>();
            for (char c : words[i].toCharArray()) {
                set.add(c);
            }
            for (int j = i + 1; j < words.length; j++) {
                Set<Character> set1 = new HashSet<>();
                char[] chars = words[j].toCharArray();
                for (int k = 0; k < chars.length; k++) {
                    set1.add(chars[k]);
                }
                if (set.size() == set1.size()){
                    boolean flag = true;
                    for (Character character : set) {
                        if (!set1.contains(character)){
                            flag = false;
                            break;
                        }
                    }
                    if (flag){
                        count++;
                    }
                }
            }

        }
        return count;
    }

    public static void main(String[] args) {
        String[] strs = {"aba","aabb","abcd","bac","aabc"};
        System.out.println(new N1().similarPairs(strs));
    }
}
