package competition.fall2022;


import java.util.*;

public class N3 {
    public int beautifulBouquet(int[] flowers, int cnt) {
        int res = 0;
        int maxKey = -1;
        int maxValue = -1;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        for (int i = 0; i < flowers.length; i++) {

            if (!map.containsKey(flowers[i])){
                map.put(flowers[i], 1);
            }else {
                int temp = map.get(flowers[i]);
                map.put(flowers[i], temp + 1);
                if (temp + 1 > maxValue) {
                    maxValue = temp + 1;
                    maxKey = flowers[i];
                }
            }
            // 当前位子的花束种类超过了
            // 那么左边减少，只要不和当前位置的种类相同，那么一直减少并计算
            // 相同，那么种类符合，接着向右移动
            // 移动的同时  减少map里的计数
            if (maxValue > cnt){
                while (left < i){
                    if (flowers[left] != flowers[i]){
                        res += (i - left);
                        map.put(flowers[left], map.get(flowers[left]) - 1);
                        left++;
                    }else {
                        res += (i - left);
                        map.put(flowers[left], map.get(flowers[left]) - 1);
                        left++;
                        maxValue--;
                        break;
                    }
                }
            }
        }
        int temp =((1 + flowers.length - left ) * (flowers.length - left)) /2;
//        System.out.println(temp);
        return res + temp;
    }

    public static void main(String[] args) {
        int[] nums = {5,3,3,3,3};
        System.out.println(new N3().beautifulBouquet(nums, 2));
    }
}
