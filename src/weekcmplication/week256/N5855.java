package weekcmplication.week256;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author hdq
 * @create 2021-08-29 10:55
 */
public class N5855 {
    public String kthLargestNumber(String[] nums, int k) {
        BigInteger[] bigIntegers = new BigInteger[nums.length];
        for (int i = 0; i < nums.length; i++) {
            bigIntegers[i] = new BigInteger(nums[i]);
        }
        Arrays.sort(bigIntegers);

        return String.valueOf(bigIntegers[bigIntegers.length-k]);
    }

    public static void main(String[] args) {
        N5855 n5855 = new N5855();
        String[] str = {"683339452288515879","7846081062003424420","4805719838","4840666580043","83598933472122816064","522940572025909479","615832818268861533","65439878015","499305616484085","97704358112880133","23861207501102","919346676","60618091901581","5914766072","426842450882100996","914353682223943129","97","241413975523149135","8594929955620533","55257775478129","528","5110809","7930848872563942788","758","4","38272299275037314530","9567700","28449892665","2846386557790827231","53222591365177739","703029","3280920242869904137","87236929298425799136","3103886291279"};
        System.out.println(n5855.kthLargestNumber(str, 3));
//        String m ="100";
//        System.out.println(Long.parseLong("6888794705"));
    }
}
