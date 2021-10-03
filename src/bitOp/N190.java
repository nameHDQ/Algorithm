package bitOp;

/**
 * @author hdq
 * @create 2021-09-01 9:12
 */
public class N190 {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res |= (n & 1) << (31-i);
            n = n >>>1;
        }
        return res;
    }

    public static void main(String[] args) {
        N190 n190 = new N190();
        System.out.println(n190.reverseBits(43261596));
    }
}
