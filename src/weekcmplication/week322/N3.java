package weekcmplication.week322;


public class N3 {
//    public int minScore(int n, int[][] roads) {
//        int res = Integer.MAX_VALUE;
//        Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();
//        Map<Integer, Integer> connect = new HashMap<>();
//        for (int i = 0; i < roads.length; i++) {
//            // 1
//            List<Pair<Integer, Integer>> temp = map.getOrDefault(roads[i][0], new ArrayList<>());
//            temp.add(new Pair<>(roads[i][1],roads[i][2]));
//            map.put(roads[i][0], temp);
//            // 2
//            List<Pair<Integer, Integer>> temp1 = map.getOrDefault(roads[i][1], new ArrayList<>());
//            temp1.add(new Pair<>(roads[i][0],roads[i][2]));
//            map.put(roads[i][1], temp1);
//        }
//        Deque<Integer> deque = new ArrayDeque<>();
//        deque.add(1);
//        while (!deque.isEmpty()){
//            int size = deque.size();
//            for (int i = 0; i < size; i++) {
//                int pop = deque.remove();
//                List<Pair<Integer, Integer>> temp;
//                if (map.containsKey(pop)){
//                    temp = map.get(pop);
//                }else {
//                    continue;
//                }
//                connect.put(pop, 1);
//                for (Pair<Integer, Integer> pair : temp) {
//                    if (!connect.containsKey(pair.getKey())){
//                        deque.add(pair.getKey());
//                        res = Math.min(pair.getValue(),res);
//                    }
//                }
//            }
//        }
//        return res;
//    }
//
//    public static void main(String[] args) {
//        int[][] num = {{1,2,9},{2,3,6},{2,4,5},{1,4,7}};
//        new N3().minScore(4,num);
//    }
}
