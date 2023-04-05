package Spring2023.redcompus;

import java.util.Arrays;
import java.util.Scanner;

public class N2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();


        while (--T >= 0){
            int n = in.nextInt();
            int k = in.nextInt();
            int[] nums = new int[n];
            int minValue = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            int[] sortedNums = nums.clone();
            Arrays.sort(sortedNums);
            int start = 0;
            for (int i = 0; i < nums.length; i++) {
                if (sortedNums[start] == nums[i]){
                    start++;
                }
            }
            int res = (nums.length - start) / k;
            System.out.println((nums.length - start) % k == 0 ?res : res + 1);
        }
    }
}
