package DayOne.simple;

public class LCP22 {
    public int paintingPlan(int n, int k) {
        if (k == 0 || k == n * n) return 1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int left = cal(n, i);
                int right = cal(n, j);
                if ( i * n + j * n - i * j == k){
                    res += left * right;
                    break;
                }
            }
        }
        return res;
    }
    public int cal(int n, int cur){
        int mother = 1;
        int son1 = 1;
        int son2 = 1;
        if (cur == 0){
            return 1;
        }
        if (cur == n){
            return 1;
        }
        for (int i = 1; i <= n; i++) {
            mother *=  i;
        }
        for (int i = 1; i <= cur; i++) {
            son1 *= i;
        }
        for (int i = 1; i <= n - cur; i++) {
            son2 *= i;
        }

        return mother / (son1 * son2);
    }
}
