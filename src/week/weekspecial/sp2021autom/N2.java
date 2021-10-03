package week.weekspecial.sp2021autom;

/**
 * @author hdq
 * @create 2021-09-11 15:58
 */
public class N2 {
    int  maxnum =0;
    public int maxmiumScore(int[] cards, int cnt) {
        int[] state = new int[cards.length];
        int[] jian = new int[cards.length];
        int maxn = 0;
        for (int i = 0; i < cards.length; i++) {
                maxn += cards[i];
                dp(state,cards,jian,cnt-1,maxn);
                maxn -= cards[i];
            jian[i] =1;
        }
        return maxnum;
    }
    public void dp(int[] state, int[] carts,int[] jian, int cnt,int maxn){
        if (cnt == 0){
            if (maxn % 2 == 0){
                if (maxn > maxnum){
                    maxnum = maxn;
                }
            }
            return;
        }
        for (int i = 0; i < state.length; i++) {
            if (state[i] == 0 && jian[i] == 0){
                state[i] =1;
                maxn += carts[i];
                dp(state,carts,jian,cnt-1,maxn);
                maxn -= carts[i];
                state[i] =0;
            }
        }
    }

    public static void main(String[] args) {
        N2 n2 = new N2();
        int[] carts = {3,3};
        System.out.println(n2.maxmiumScore(carts, 2));
    }
}
