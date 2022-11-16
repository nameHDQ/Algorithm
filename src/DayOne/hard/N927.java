package DayOne.hard;

import java.util.ArrayList;
import java.util.List;

public class N927 {
    public int[] threeEqualParts(int[] arr) {

        int count_1 = 0;
        int count_0 = 0;
        for (int i : arr) {
            if (i == 1){
                count_1++;
            }else {
                count_0++;
            }
        }
        if (count_1 % 3 != 0) return new int[]{-1,-1};
        if (count_0 == arr.length) return new int[]{0,arr.length-1};
        int avg_1 = count_1 / 3;
        int countTail_0 = 0;
        for (int i = arr.length - 1; i >= 0 ; i--) {
            if (arr[i] == 1){
                break;
            }
            countTail_0++;
        }
        int[] idx = new int[2];
        int id = 0;
        int count1 =0;
        for (int k = 0; k < arr.length; k++) {

            if (arr[k] == 1){
                count1++;
            }
            if (count1 == avg_1){
                int count0 = 0;
                int index = k + 1;
                // 计算连续0的个数
                while (count0 < countTail_0 && index < arr.length){
                    if (arr[index] == 0){
                        count0++;
                    }else {
                        return new int[]{-1,-1};
                    }
                }
                idx[id++] = k + countTail_0;
                count1 = 0;
            }
            if (id == 2){
                break;
            }
        }
        // 测试每个区域的值是否相等
        int tempa = 0, m = 0;

        for (int i = idx[0]; i >= 0; i--){
            tempa +=  arr[i] * (1 << m);
            m++;
        }
        int tempb = 0;
        m = 0;

        for (int i = idx[1]; i >idx[0]; i--){
            tempb +=  arr[i] * (1 << m);
            m++;
        }
        if (tempb != tempa) return new int[]{-1,-1};
        m = 0;
        int tempc = 0;
        for (int i = arr.length - 1; i > idx[1]; i--){
            tempc += arr[i] * (1 << m);
            m++;
        }
        if (tempb != tempc) return new int[]{-1,-1};
        return new int[]{0,idx[1] + 1};
    }

    public static void main(String[] args) {
        int[] arr = {1,1,0,0,1};
        new N927().threeEqualParts(arr);
    }
}
