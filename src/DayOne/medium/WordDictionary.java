package DayOne.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hdq
 * @create 2021-10-19 16:57
 */
class WordDictionary {
    private  static List<String> arrayList = new ArrayList<>();
    public WordDictionary() {
    }

    public void addWord(String word) {
        arrayList.add(word);
    }

    public boolean search(String word) {
        if (arrayList.contains(word)){
            return true;
        }else {
            for (String s : arrayList) {
                if (s.length() != word.length()){
                    continue;
                }else {
                    for (int i = 0; i < word.length(); i++) {
                        if (word.charAt(i) == s.charAt(i)){
                            if (i == word.length()-1){
                                return true;
                            }
                            continue;
                        }else {
                            if (word.charAt(i) == '.'){
                                if (i == word.length()-1){
                                    return true;
                                }
                                continue;
                            }
                            break;
                        }
                    }
                    return false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
//        wordDictionary.addWord("bad");
//        wordDictionary.addWord("mad");
//        wordDictionary.addWord("dad");
        System.out.println(wordDictionary.search("a")); // return True;
//        System.out.println(wordDictionary.search("..."));
//        System.out.println(wordDictionary.search("b.."));
    }
}