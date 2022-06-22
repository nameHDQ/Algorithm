package DayOne.medium;

/**
 * @author hdq
 * @create 2022-03-19 13:28
 */
public class N421 {

    nextNode root = new nextNode();
    public static int BIT = 30;
    public int findMaximumXOR(int[] nums) {

        int n = nums.length;
        int max = 0;
        for (int i = 1; i < n; i++) {
            add(nums[i-1]);
            max = Math.max(max, search(nums[i]));

        }
        return max;
    }
    public int search(int num) {
        nextNode node = root;
        int res = 0;
        for (int i = BIT; i >= 0; i--) {
            // 如果当前位是1，那么下一个节点应该是0（左节点）才能异或得1
            int bit = (num >> i) & 1;
            if (bit == 1) {
                // 选 0
                if (node.left != null) {
                    node = node.left;
                    res += (1 << i);
                }else {
                    node = node.right;
                }
            }else {
                // 选 1
                if (node.right != null) {
                    node = node.right;
                    res += (1 << i);
                }else {
                    node = node.left;
                }
            }
        }
        return res;
    }
    public void add(int num) {
        nextNode node = root;
        for (int i = BIT; i >= 0; i--) {
            // 如果当前位是1，往右节点走
            int bit = (num >> i) & 1;
            if (bit == 1) {
                if (node.right == null) {
                    node.right = new nextNode();
                }
                node = node.right;
            }else {
                if (node.left == null) {
                    node.left = new nextNode();
                }
                node = node.left;
            }
        }
    }
    class nextNode{
        nextNode left = null;
        nextNode right = null;
    }

    public static void main(String[] args) {
        System.out.println(new N421().findMaximumXOR(new int[]{2,4}));
    }
}
