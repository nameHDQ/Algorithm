package DayOne.medium;

/**
 * @author hdq
 * @create 2021-12-04 12:44
 */
public class N74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m-1;
        while (l <= r){
            int mid = (l+r)/2;
            if (matrix[mid][0] > target){
                r = mid-1;
                continue;
            }
            if (matrix[mid][n-1] < target){
                l = mid+1;
                continue;
            }
            int innerL = 0;
            int innerR = n-1;
            while (innerL <= innerR){
                int innerMid = (innerL+innerR)/2;
                if (matrix[mid][innerMid] == target){
                    return true;
                }else if (matrix[mid][innerMid] > target){
                    innerR = innerMid-1;
                    continue;
                }else if (matrix[mid][innerMid] < target){
                    innerL= innerMid+1;
                    continue;
                }
            }
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        N74 n74 = new N74();
        int[][] nums = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(n74.searchMatrix(nums, 13));
    }
}
