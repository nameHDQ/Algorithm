package DayOne.medium;

import java.util.Set;

/**
 * @author hdq
 * @create 2022-04-13 10:07
 */
public class N380 {
    class RandomizedSet {

        Set<Integer> set;

        public RandomizedSet() {
            set = new java.util.HashSet<>();
        }

        public boolean insert(int val) {
            if (set.contains(val)){
                return false;
            }
            set.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (set.contains(val)){
                set.remove(val);
                return true;
            }
            return false;
        }

        public int getRandom() {
            int index = (int) (Math.random() * set.size());
            return set.stream().skip(index).findFirst().get();
        }
    }

}
