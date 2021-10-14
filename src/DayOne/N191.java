package DayOne;



/**
 * @author hdq
 * @create 2021-08-31 11:36
 */
public class N191 {
    public int hammingWeight(int n) {
        int ans =0;
        while (n != 0){
            if (n >0) {
                ans += n % 2;
                n = n >> 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        N191 n191 = new N191();
    }
}
