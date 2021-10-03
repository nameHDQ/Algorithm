package DayOne;

import java.util.Arrays;

/**
 * @author hdq
 * @create 2021-08-21 14:02
 */
public class N167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] resu = new int[2];
        for (int i = 0,j = i+1; i < numbers.length-1&&j<numbers.length; ) {
            if (numbers[i] > target){
                break;
            }
            if (numbers[i] + numbers[j] == target){
                resu[0] = i+1;
                resu[1] = j+1;
                return resu;
            }
            if (numbers[i] + numbers[j] > target){
                i++;
                j=i+1;
                continue;
            }
            if (numbers[i] + numbers[j] < target){
                if (j == numbers.length-1){
                    i++;
                    j=i+1;
                }else {
                    j++;
                }
                continue;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        N167 n167 = new N167();
        int[] numbers = {5,25,75};

        System.out.println(Arrays.toString(n167.twoSum(numbers, 100)));
    }
}
