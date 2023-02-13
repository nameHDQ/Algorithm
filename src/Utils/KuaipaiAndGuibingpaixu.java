package Utils;

import DayOne.medium.N718;

import java.util.ArrayList;
import java.util.List;

public class KuaipaiAndGuibingpaixu {

    public void quickSort(int left, int right, int[] nums){

        if (left >= right) return;

        int x = nums[(left + right) / 2], i = left - 1, j = right + 1;
        while (i < j) {
            do {
                i++;
            } while (nums[i] < x);
            do {
                j--;
            } while (nums[j] > x);

            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        quickSort(left, j,nums);
        quickSort(j + 1, right, nums );
    }

    public void fastSort1(int left, int right, int[] nums){
        if (left >= right) return;
        int curLeft = left - 1, curRight = right +1, mid = nums[(left + right) / 2];

        while (curLeft < curRight){
            do {
                curLeft++;
            }while (nums[curLeft] <mid);
            do {
                curRight--;
            }while (nums[curRight] > mid);
            if (curLeft < curRight){
                int temp = nums[curLeft];
                nums[curLeft] = nums[curRight];
                nums[curRight] = temp;
            }
        }

        fastSort1(left, curRight, nums);
        fastSort1(curRight + 1, right, nums);

    }

    int[] temp;
    public void GuiBinStart(int left, int right, int[] nums){

        GuiBin(left, right, nums);
    }

    public void GuiBin(int left, int right, int[] nums){
        if (left >= right) return;

        int mid = (left + right) >> 1;
        GuiBin(left, mid, nums);
        GuiBin(mid + 1, right, nums);

        List<Integer> temp = new ArrayList<>();
        int leftStart = left, rightStart = mid + 1;
        while (leftStart <= mid && rightStart <= right){
            if (nums[leftStart] <= nums[rightStart]){
                temp.add(nums[leftStart]);
                leftStart++;
            }else {
                temp.add(nums[rightStart]);
                rightStart++;
            }
        }

        while (leftStart <= mid){
            temp.add(nums[leftStart]);
            leftStart++;
        }
        while (rightStart <= right){
            temp.add(nums[rightStart]);
            rightStart++;
        }
        for (Integer integer : temp) {
            nums[left++] = integer;
        }
    }

    private void swap(int l, int r, int[] nums) {
        int tem = nums[l];
        nums[l] = nums[r];
        nums[r] = tem;
    }

    public static void main(String[] args) {
        int[] nums = {4,19,14,5,-3,1,8,5,11,15};
        System.out.println(2 + 4 >> 1);
        new KuaipaiAndGuibingpaixu().fastSort1(0,nums.length - 1,nums);
//        new KuaipaiAndGuibingpaixu().GuiBinStart(0, nums.length - 1, nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }


}
