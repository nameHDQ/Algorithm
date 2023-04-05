package niuniu.mediumClass;

import java.util.Scanner;

public class N3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int num = in.nextInt();
        int window = in.nextInt();
        int[] nums = new int[num];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextInt();
        }
        int res = 1;
        int left = 0;
        for (int i = 1; i < nums.length; i++) {
            while (nums[i] - nums[left] + 1 > window){
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        System.out.println(res);
    }
}
