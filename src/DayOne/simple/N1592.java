package DayOne.simple;

import java.util.ArrayList;
import java.util.List;

public class N1592 {
    public String reorderSpaces(String text) {

        int len = text.length();
        int wordsLen = 0;
        String[] s = text.split(" ");
        int count_words = 0;
        List<String> words = new ArrayList<>();
        for (String s1 : s) {
            if (!s1.equals("")){
                count_words++;
                wordsLen += s1.length();
                words.add(s1);
            }
        }

        int avg_null = (len - wordsLen) / ((count_words - 1) == 0 ? Integer.MAX_VALUE : (count_words - 1));

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.size() - 1; i++) {
            stringBuilder.append(words.get(i));
            for (int j = 0; j < avg_null; j++) {
                stringBuilder.append(" ");
            }
        }
        stringBuilder.append(words.get(words.size() - 1));
        int tail = ((count_words - 1) == 0 ? len - wordsLen : (len - wordsLen) % (count_words - 1));
        for (int i = 0; i < tail; i++) {
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        new N1592().reorderSpaces("  walks  udp package   into  bar a");
    }
}
