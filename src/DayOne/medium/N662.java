package DayOne.medium;


public class N662 {
//    public int widthOfBinaryTree(TreeNode root) {
//        List<Pair<TreeNode, Integer>> list = new ArrayList<>();
//        list.add(new Pair<>(root, 1));
//        int maxWith = 1;
//        while (!list.isEmpty()){
//            List<Pair<TreeNode, Integer>> nextLevel = new ArrayList<>();
//            for (Pair<TreeNode, Integer> pair : list) {
//                TreeNode node = pair.getKey();
//                Integer index = pair.getValue();
//                if (node.left != null) nextLevel.add(new Pair<>(node.left, index * 2));
//                if (node.right != null) nextLevel.add(new Pair<>(node.right, index * 2 + 1));
//
//            }
//            maxWith = Math.max(maxWith, list.get(list.size() - 1).getValue() - list.get(0).getValue() + 1);
//            list = nextLevel;
//        }
//        return maxWith;
//    }
}
