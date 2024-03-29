package DayOne.simple;


import java.util.Arrays;

public class N349 {
    public int[] intersection(int[] nums1, int[] nums2) {

        return Arrays.stream(nums1).filter(i -> {

            for (int j : nums2){
                if (i == j) return true;
            }
            return false;
        }).distinct().toArray();
    }

    public static void main(String[] args) {

        int[] nums1= { 4,9,5};
        int[] nums2= { 9,4,9,8,4};
        int[] intersection = new N349().intersection(nums1, nums2);
    }
}
