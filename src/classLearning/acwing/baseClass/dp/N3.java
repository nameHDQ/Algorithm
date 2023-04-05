package classLearning.acwing.baseClass.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int N = in.nextInt();
        int capacity = in.nextInt();
        List<Integer> volume = new ArrayList<>();
        List<Integer> price = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int tempVolume = in.nextInt();
            int tempPrice = in.nextInt();
            int size = in.nextInt();
            int k = 1;
            while (size >= k){
                volume.add(tempVolume * k);
                price.add(tempPrice * k);
                size -= k;
                k *= 2;
            }
            if (size > 0){
                volume.add(tempVolume * size);
                price.add(tempPrice * size);
            }
        }

        int[][] dp = new int[volume.size() + 1][capacity + 1];
        for (int i = 1; i <= volume.size(); i++) {
            for (int j = 0; j <= capacity; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= volume.get(i - 1)){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - volume.get(i  -1)] + price.get(i - 1));
                }
            }
        }
        System.out.println(dp[volume.size()][capacity]);
    }
}
