package weekcmplication.week293;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author hdq
 * @create 2022-05-15 10:28
 */
public class N1 {
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();


        int len = words.length;
        if (len == 1) {
            res.add(words[0]);
            return res;
        }
        int preIndex = 0;
        res.add(words[preIndex]);
        for (int i = 1; i < len; i++) {
            String word = words[i];
            String preWord = words[preIndex];
            // 长度不同，非异位字母直接添加
            if (word.length() != preWord.length()) {
                res.add(word);
                preIndex = i;
                continue;
            }
            // 异位字母
            int[] count1 = new int[26];
            int[] count2 = new int[26];
            // 字母相同，异味字母，直接删除
            if (word.equals(preWord)) {
                continue;
            }
            // 不相同，异味字母
            for (int j = 0; j < word.length(); j++) {
                count1[word.charAt(j) - 'a']++;
                count2[preWord.charAt(j) - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                // 字母不同，非异位字母，直接添加
                if (count1[j] != count2[j]) {
                    res.add(word);
                    preIndex = i;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] str = {"a","b","c","d","e"};
        System.out.println(new N1().removeAnagrams(str));
    }
}
