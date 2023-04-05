package classLearning.acwing.baseClass.dp;

import java.util.Scanner;

public class N7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int N = in.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = in.nextInt();
        }
        int res = 1;
        int[] st = new int[1000015];
        int index = 0;
        st[index++] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > st[index]){
                st[index++] = nums[i];
            }else {
                int l = 0, r = index - 1;
                while(l < r)
                {
                    int mid = (l + r) >> 1;
                    if(st[mid] >= nums[i]) r = mid;
                    else l = mid + 1;
                }
                st[l] = nums[i];
            }
            res = Math.max(res, index);
        }
        System.out.println(res);
    }
}
