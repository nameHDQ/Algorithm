package DayOne.simple;

/**
 * @author hdq
 * @create 2021-10-14 9:53
 */
public class JZII069 {
    public int peakIndexInMountainArray(int[] arr) {
        int pre = arr[0];
        for (int i = 1; i < arr.length-1; i++) {
            if (arr[i] > pre && arr[i] > arr[i+1]){
                return i;
            }else {
                pre = arr[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        JZII069 jzii069 = new JZII069();
        int[] arr ={24,69,100,99,79,78,67,36,26,19};
        System.out.println(jzii069.peakIndexInMountainArray(arr));
    }
}
