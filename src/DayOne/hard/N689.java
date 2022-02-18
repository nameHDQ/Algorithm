package DayOne.hard;

/**
 * @author hdq
 * @create 2021-12-08 11:50
 */
public class N689 {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int sum1 = 0, maxSum1 = 0,maxSum1InxTemp = 0;
        int sum2 = 0, maxSum1And2 = 0,maxSum2Inx = 0,maxSum1Inx = 0;
        int sum3 = 0, maxSum123 = 0;
        int[] inx = new int[3];
        for (int i = k*2; i < nums.length; i++) {
            sum1 +=nums[i-k*2];
            sum2 +=nums[i-k];
            sum3 +=nums[i];
            if (i>=3*k-1){
                if (sum1 > maxSum1){
                    maxSum1 = sum1;
                    maxSum1InxTemp = i-k*3+1;
                }
                //同第三个 如果第一个的新结果没有之前的大，也不更新
                if (maxSum1+sum2 > maxSum1And2){
                    maxSum1And2 = maxSum1+sum2;
                    //结果更大 更新第一个的坐标
                    maxSum1Inx  =maxSum1InxTemp;
                    maxSum2Inx = i-k*2+1;
                }
                //如果总和没有之前的大，说明这个不行，不更新坐标
                if (maxSum1And2 + sum3 > maxSum123){
                    maxSum123 = maxSum1And2 + sum3;
                    inx[0] = maxSum1Inx;
                    inx[1] = maxSum2Inx;
                    inx[2] = i-k+1;

                }
                sum1 -=nums[i-k*3+1];
                sum2 -=nums[i-k*2+1];
                sum3 -=nums[i-k+1];
            }
        }

        return inx;
    }

    public static void main(String[] args) {
        N689 n689 = new N689();
        int[] arr ={4,5,10,6,11,17,4,11,1,3};
        for (int i : n689.maxSumOfThreeSubarrays(arr, 1)) {
            System.out.println(i);
        }
    }
}
