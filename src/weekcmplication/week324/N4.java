package weekcmplication.week324;

public class N4 {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int[] res = new int[queries.length];
        int idx = 0;
        for (int[] query : queries) {
            res[idx++] = findParent(query[0],query[1], 0) + 1;

        }
        return res;
    }

    public int findParent(int p, int q, int depth){
        if (p == q){
            return depth;
        }
        //
        if (p > q){
            return findParent(p / 2, q,depth + 1);
        }else {
            return findParent(p, q/ 2,depth + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new N4().findParent(5, 6, 0));
    }
}
