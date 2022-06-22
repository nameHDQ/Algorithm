package DayOne.DataStruct;

/**
 * @author hdq
 * @create 2022-03-17 20:55
 */
public class DictionaryTree {
    static class trie1 {
        int N = 100009; // 直接设置为十万级
        int[][] next; // 第一维表示当前是第几个节点，第二维是该节点存储是哪个字母，存储的值下一个字符节点的编号
        int[] count; // 某个结点被标记为结尾边界的个数
        int index; // 用到的总节点个数

        public trie1() {
            next = new int[N][26];
            count = new int[N];
            index = 0;
        }

        public void insert(String s) {
            // 起始都为0 根据index总结点的个数 跳到不同的点，总共有多少个节点就用到多少个一维
            int p = 0;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                // 如果没有这个字母, 申请一个新的节点  插入进去
                if (next[p][u] == 0) next[p][u] = ++index;
                // 下个字母的坐标
                p = next[p][u];
            }
            // 如果是一个单词, 就把这个单词的计数器加一
            count[p]++;
        }

        public boolean search(String s) {
            int p = 0;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (next[p][u] == 0) return false;
                p = next[p][u];
            }
            return count[p] != 0;
        }

        public boolean startsWith(String s) {
            int p = 0;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (next[p][u] == 0) return false;
                p = next[p][u];
            }
            return true;
        }
    }

    public static void main(String[] args) {
        trie1 next1 = new trie1();
        next1.insert("abc");
        next1.insert("afrd");
        next1.insert("cbce");
    }

    /**
     * 理论同二维数组写法，只不过把下一个节点的存储方式由二维数组改成nextNode对象
     */
    class trie2 {
        class nextNode {
            boolean end;
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
                p = p.tns[u];
            }
            p.end = true;
        }

        public boolean search(String s) {
            nextNode p = root;
            for(int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (p.tns[u] == null) return false;
                p = p.tns[u];
            }
            return p.end;
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
}
