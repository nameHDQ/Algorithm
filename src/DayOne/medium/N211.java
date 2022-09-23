package DayOne.medium;

/**
 * @author hdq
 * @create 2022-03-18 19:06
 */
public class N211 {
    class WordDictionary {
        private static final int N = 100009;
        private static final int M = 26;
        int [][] next;
        int[] count;
        int index;

        public WordDictionary() {
            next = new int[N][M];
            count = new int[N];
            index = 0;
        }

        public void addWord(String word) {
            int p = 0;
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                if (next[p][c] == 0) next[p][c] = ++index;
                p = next[p][c];
            }
            count[p]++;
        }

        public boolean search(String word) {
            return dfs(word, 0, 0);
        }

        private boolean dfs(String word, int trieIndex, int wordIndex) {
            int n = word.length();
            if (wordIndex == n) return count[trieIndex] > 0;
            if (word.charAt(wordIndex) == '.') {
                for (int i = 0; i < M; i++) {
                    if (next[trieIndex][i] != 0) {
                        if (dfs(word, next[trieIndex][i], wordIndex + 1)) return true;
                    }
                }
                return false;
            }else {
                int c = word.charAt(wordIndex) - 'a';
                if (next[trieIndex][c] == 0) return false;
                return dfs(word, next[trieIndex][c], wordIndex + 1);
            }
        }
    }
}
