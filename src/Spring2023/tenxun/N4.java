package Spring2023.tenxun;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class N4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int N = in.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = in.nextInt();
        }
        BigInteger[] preOdd = new BigInteger[N];
        BigInteger[] preX = new BigInteger[N];
        Arrays.fill(preOdd, 1);
        preOdd[0] = BigInteger.valueOf(nums[0]);
        preX[0] = BigInteger.valueOf(nums[0]);
        for (int i = 1; i < N; i++) {
            preOdd[i] = preOdd[i - 1].multiply(BigInteger.valueOf(nums[i]));
            preX[i] = preX[i - 1].xor(BigInteger.valueOf(nums[i]));
        }
        int ans = N;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (i > 0){
                    if ((preOdd[j].divide(preOdd[ i - 1])) .equals (preX[j].xor( preX[i - 1]))){
                        ans++;
                    }
                }else {
                    if (preOdd[j].equals( preX[j])){
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
