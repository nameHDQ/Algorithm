package DayOne.medium;

/**
 * @author hdq
 * @create 2021-12-05 9:56
 */
public class N372 {
    int MOD = 1337;
    public int superPow(int a, int[] b) {
        return dfs(a, b, b.length-1);
    }
    public int dfs(int a, int b[],int len){
        if (len == -1) return 1;
        return powAB(dfs(a, b, len-1), 10)*powAB(a, b[len])%MOD;
    }
    public int powAB(int a, int b){
        int ans = 1;
        a %= MOD;
        while (b != 0) {
            //此时的若右规后有奇数位 则an为累积后的最低位
            if ((b & 1) != 0) ans = ans * a % MOD;
            // a2*a2=a4   a4*a4 = a8  所以要b>>1
            a = a * a % MOD;
            b >>= 1;
        }
        return ans;
    }



    public static void main(String[] args) {
        N372 n372 = new N372();
        int[] arr = {2,0,0};
        System.out.println(8>>1);
        System.out.println(n372.superPow(2147483647, arr));
    }
}
