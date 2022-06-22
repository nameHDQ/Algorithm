package DayOne.simple;

import java.util.Arrays;

/**
 * @author hdq
 * @create 2022-06-19 11:53
 */
public class N1089 {
    public void duplicateZeros(int[] arr) {
        int len = arr.length;
        int[] temp = Arrays.copyOf(arr,len);

        int index_temp = 0;
        for (int i = 0; i < len; i++) {
            if (temp[index_temp] == 0){
                arr[i] = 0;
                if (i + 1 < len) {
                    arr[i + 1] = 0;
                    i++;
                }

            }else {
                arr[i] = temp[index_temp];
            }
            index_temp++;
        }
        return;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0,0,0};
        new N1089().duplicateZeros(arr);
    }
}
