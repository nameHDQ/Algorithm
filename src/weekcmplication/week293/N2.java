package weekcmplication.week293;

import java.util.Collections;
import java.util.Map;

/**
 * @author hdq
 * @create 2022-05-15 10:28
 */
public class N2 {
    public int maxConsecutive(int bottom, int top, int[] special) {

        int sLen = special.length;
        int[] temp = new int[sLen];
        if (sLen == 1) {
            temp[0] = special[0];
        }
        mergeSort(special,0,sLen-1,temp);
//        System.out.println(temp[0]);
        int sMin = temp[0];
        int sMax = temp[temp.length-1];
        int leftLen = sMin - bottom;
        int rightLen = top - sMax;
        int tempMax = 0;
        for (int i = sLen - 1; i > 0; i--) {
            int dist = temp[i] - temp[i-1] - 1;
            if (dist > tempMax) {
                tempMax = dist;
            }
        }
        return Math.max(Math.max(leftLen,rightLen) , tempMax);
    }
    public  void mergeSort(int[] arr, int left, int right, int[] temp) {
        if(left < right) {
            int mid = (left + right) / 2;
            //向左递归分解
            mergeSort(arr,left,mid,temp);
            //向右递归分界
            mergeSort(arr,mid+1,right,temp);
            //合并
            merge(arr,left,mid,right,temp);
        }
    }
    public  void merge(int[] arr,int left, int mid, int right, int[] temp) {
        int i = left; //左边有序序列的初始索引
        int j = mid + 1; //右边有序序列的初始索引
        int t = 0; //指向temp数组的当前索引
        while (i <= mid && j <= right) {
            if (arr[i] > arr[j]) {
                temp[t++] = arr[j++];
            } else {
                temp[t++] = arr[i++];
            }
        }
        //把有剩余数据的一边的数据全部依次填充到temp中
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        //将temp数组中的数据拷贝到arr数组中去
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[t++];
        }
    }

    public static void main(String[] args) {

        System.out.println(new N2().maxConsecutive(6, 39, new int[]{38}));
    }
}
