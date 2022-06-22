package DayOne.medium;

/**
 * @author hdq
 * @create 2022-04-29 10:42
 */
public class N427 {
    public Node construct(int[][] grid) {


        return dfs(grid, 0, 0, grid.length - 1, grid[0].length - 1);
    }

    private Node dfs(int[][] grid, int startX, int startY, int endX, int endY) {
        boolean isLeaf = true;
        int temp = grid[startX][startY];
        for (int i = startX; i <= endX && isLeaf; i++) {
            for (int j = startY; j <= endY && isLeaf; j++) {
                if (grid[i][j] != temp) {
                    isLeaf = false;
                }
            }
        }
        // 如果是叶子节点，没有子节点，直接返回
        if (isLeaf) {
            return new Node(temp == 1, isLeaf);
        }
        // 如果不是叶子节点，则创建子节点
        Node node = new Node(temp == 1, isLeaf);
        int dx = endX - startX + 1;
        int dy = endY - startY + 1;
        node.topLeft = dfs(grid, startX, startY, startX + dx / 2 - 1, startY + dy / 2 - 1);
        node.topRight = dfs(grid, startX , startY + dy / 2, startX + dx / 2 - 1, endY);
        node.bottomLeft = dfs(grid, startX + dx / 2 , startY , endX, startY + dy / 2 - 1);
        node.bottomRight = dfs(grid, startX + dx / 2, startY + dy / 2, endX, endY);
        return node;
    }
}

// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
