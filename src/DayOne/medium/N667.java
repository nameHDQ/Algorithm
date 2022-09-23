package DayOne.medium;

public class N667 {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int idx = 0;

        for (int i = 1; i < n - k; i++) {
            res[idx] = i;
            idx++;
        }

        for (int i = n - k, j = n; i <= j; i++,j--){
            res[idx++] = i;
            if ( i!=j ){
                res[idx++] = j;
            }
        }
        return res;
    }

}
