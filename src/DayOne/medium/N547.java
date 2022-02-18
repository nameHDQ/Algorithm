package DayOne.medium;

/**
 * @author hdq
 * @create 2021-12-09 10:54
 */
public class N547 {
    public int findCircleNum(int[][] isConnected) {
        int circle = 0;
        int province = isConnected.length;
        boolean[] isVisited = new boolean[province];
        for (int i = 0; i < province; i++) {
            if (!isVisited[i]){
                dfs(isVisited,province,i,isConnected);
                circle++;
            }
        }
        return circle;
    }
    public void dfs(boolean[] isVisited,int province,int i,int[][] isConnected){
        for (int j = 0; j < isConnected[i].length; j++) {
            if (isConnected[i][j] == 1 && !isVisited[j]){
                isVisited[j] = true;
                dfs(isVisited,province,j,isConnected);
            }
        }
    }
}
