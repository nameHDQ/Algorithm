package DayOne;

import java.util.jar.JarEntry;

/**
 * @author hdq
 * @create 2021-08-21 13:11
 */
public class N283 {
    public void moveZeroes(int[] nums) {
        if (nums.length == 1){
            return;
        }
        for (int i = 0,j =i+1 ; i <nums.length-1 && j<nums.length; ) {
            if (nums[i] == 0 && nums[j] !=0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
                continue;
            }
            if (nums[i] == 0 &&nums[j] == 0){
                j++;
                continue;
            }
            if (nums[i] !=0 ){

                if (j ==i+1 ){
                    j++;
                }
                i++;
            }
        }
        for (int x :
                nums) {
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        N283 n283 = new N283();
        int[] zer = {4,2,4,0,0,3,0,5,1,0};
        n283.moveZeroes(zer);
    }
}
