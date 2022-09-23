package weekcmplication.week311;

import DayOne.DataStruct.DictionaryTree;

public class N4 {
    public int[] sumPrefixScores(String[] words) {


        int[] nums = new int[words.length];
        trie2 dictTree = new trie2();
        for (int i = 0; i < words.length; i++) {
            dictTree.insert(words[i]);
        }

        for (int i = 0; i < words.length; i++) {
            nums[i] = dictTree.search(words[i]);
        }


        return nums;
    }
    class trie2 {
        class nextNode {
            boolean end;
            int count = 1;
           nextNode[] tns = new nextNode[26];
        }

        nextNode root;
        public trie2() {
            root = new nextNode();

        }

        public void insert(String s) {
            nextNode p = root;
            for(int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (p.tns[u] == null) p.tns[u] = new nextNode();
                // 记录个数
                else p.tns[u].count+=1;
                p = p.tns[u];
            }
            p.end = true;
        }

        public int search(String s) {
            int res = 0;
            nextNode p = root;
            for(int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (p.tns[u] == null) return res;
                else res += p.tns[u].count;
                p = p.tns[u];
            }
            return res;
        }

        public boolean startsWith(String s) {
            nextNode p = root;
            for(int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (p.tns[u] == null) return false;
                p = p.tns[u];
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String[] str = {"abc","ab","bc","b"};
        new N4().sumPrefixScores(str);
    }
}
