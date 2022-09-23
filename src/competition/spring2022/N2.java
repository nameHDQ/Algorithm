package competition.spring2022;


import javax.print.attribute.standard.OrientationRequested;

/**
 * @author hdq
 * @create 2022-04-16 15:07
 */
public class N2 {
    int w = -1;
    int sumLimit = 0;
    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        int max = 0;
        sumLimit = limit;
        dfs(materials, cookbooks, attribute, 0, max, 0);
        return w;
    }
    // 每种食物，选择做与不做
    public void dfs(int[] materials, int[][] cookbooks, int[][] attribute, int index, int max, int limit){
        if (index == cookbooks.length){
            if (limit < sumLimit){
                return;
            }else {
                if (max > w){
                    w = max;
                    return;
                }
                return;
            }
        }
        // 先判断材料是否够做，不够则不做,属性不变
        for (int i = 0; i < 5; i++) {
            if (materials[i] < cookbooks[index][i]) {
                dfs(materials, cookbooks,attribute, index + 1, max, limit);
                return;
            }
        }
        // 材料够做了，则减去材料，并且加上美味度和饱腹感
        for (int i = 0; i < 5; i++) {
            materials[i] -= cookbooks[index][i];
        }
        dfs(materials, cookbooks,attribute, index + 1, max + attribute[index][0], limit + attribute[index][1]);

        // 材料够不做，先恢复材料，属性则不变
        for (int i = 0; i < 5; i++) {
            materials[i] += cookbooks[index][i];
        }
        dfs(materials, cookbooks,attribute, index + 1, max, limit);
    }

    public static void main(String[] args) {
        int[] ma = {3,2,4,1,2};
        int[][] cook = {{1,1,0,1,2},{2,1,4,0,0},{3,2,4,1,0}};
        int[][] attr = {{3,2},{2,4},{7,6}};
        int limit = 5;
        System.out.println(new N2().perfectMenu(ma, cook, attr, limit));
    }
}
