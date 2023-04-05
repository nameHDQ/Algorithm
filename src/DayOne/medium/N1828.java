package DayOne.medium;

public class N1828 {
    public int[] countPoints(int[][] points, int[][] queries) {

        int len = queries.length;
        int[] ans = new int[len];

        for (int i = 0; i < queries.length; i++) {
            for (int[] point : points) {
                int x = point[0];
                int y = point[1];
                if ((queries[i][0] - x) * (queries[i][0] - x) + (queries[i][1] - y) * (queries[i][1] - y) <= queries[i][2] * queries[i][2]){
                    ans[i]++;
                }
            }
        }
        return ans;
    }
}
