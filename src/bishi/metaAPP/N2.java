package bishi.metaAPP;

import java.security.Key;

public class N2 {

    public static int[] answer(int[] x) {
        int len = x.length;
        int ans1 = Integer.MIN_VALUE;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                ans1 = Math.max(ans1, Math.min(x[i],x[j]) * (j - i));
            }
        }
        int[] ans2 = new int[14];
        for (int i = 13; i >= 0; i--) {
            ans2[13 - i] = ans1 * i + 95;
        }
        int[] ans3 = new int[14 * 3];
        int index = 0;
        for (int i = ans2.length - 1; i >= 0 ; i--) {
            for (int j = 0; j < 3; j++) {
                ans3[index++] = ans2[i];
            }
        }
        return ans3;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,1,4,2,6};
        N2.answer(nums);
    }
}
