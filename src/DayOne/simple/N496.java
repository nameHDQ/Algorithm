package DayOne.simple;

/**
 * @author hdq
 * @create 2021-10-26 9:12
 */
public class N496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            boolean flag = false;
            boolean change = false;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]){
                    flag = true;
                }
                if (nums2[j] > nums1[i] && flag){
                    res[i] = nums2[j];
                    change = true;
                    break;
                }
            }
            if (!change){
                res[i] = -1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        N496 n496 = new N496();
        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};
        for (int i : n496.nextGreaterElement(nums1, nums2)) {
            System.out.println(i);
        }
    }
}
