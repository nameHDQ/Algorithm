package DayOne.medium;

/**
 * @author hdq
 * @create 2022-03-17 21:31
 */
public class N208 {
    class Trie {
        private static final int N = 100009;
        private static final int M = 26;
        int[] count;
        int[][] next;
        int index;
        public Trie() {
            next = new int[N][M];
            count = new int[N];
            index = 0;
        }

        public void insert(String word) {
            int p = 0;
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                // 如果没有这个字母, 申请一个新的节点  插入进去
                if (next[p][c] == 0) {
                    next[p][c] = ++index;
                }
                // 下个字母的坐标
                p = next[p][c];
            }
            // 如果是一个单词, 就把这个单词的计数器加一
            count[p]++;
        }

        public boolean search(String word) {
            int p = 0;
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                if (next[p][c] == 0) {
                    return false;
                }
                p = next[p][c];
            }
            return count[p] > 0;
        }

        public boolean startsWith(String prefix) {
            int p = 0;
            for (int i = 0; i < prefix.length(); i++){
                int c = prefix.charAt(i) - 'a';
                if (next[p][c] == 0){
                    return false;
                }
                p = next[p][c];
            }
            return true;
        }
    }
}
