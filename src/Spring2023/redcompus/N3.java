package Spring2023.redcompus;

import java.util.Scanner;

public class N3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int len = Integer.parseInt(in.nextLine());
        int[] nums = new int[len];
        String[] strNums = in.nextLine().split(" ");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strNums[i]);
        }
        int M = Integer.parseInt(in.nextLine());
        int[] lefts = new int[M];
        int[] rights = new int[M];
        int[] opNums = new int[M];
        String[] strLeft = in.nextLine().split(" ");
        String[] strRight = in.nextLine().split(" ");
        String op = in.nextLine();
        String[] strOp = in.nextLine().split(" ");
        for (int i = 0; i < M; i++) {
            lefts[i] = Integer.parseInt(strLeft[i]);
            rights[i] = Integer.parseInt(strRight[i]);
            opNums[i] = Integer.parseInt(strOp[i]);
        }
        int start = 0;
        for (int i = op.length() - 1; i >- 0; i--) {
            if (op.charAt(i) == '='){
                start = i;
                break;
            }
        }
        for (int i = start; i < M; i++) {
            int left = lefts[i] - 1;
            int right = rights[i] - 1;
            char operation = op.charAt(i);
            if (operation == '='){
                continue;
            }
            while (left <= right){
                if (operation == '|'){
                    nums[left] |= opNums[i];
                }
                if (operation == '&'){
                    nums[left] &= opNums[i];
                }
                if (operation == '='){
                    nums[left] = opNums[i];
                }
                left++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }
//    4
//            5 4 7 4
//            4
//            1 2 3 2
//            4 3 4 2
//            =|&=
//            8 3 6 2
}
