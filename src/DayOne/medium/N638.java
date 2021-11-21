package DayOne.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hdq
 * @create 2021-10-24 17:15
 */
public class N638 {
    Map<List<Integer>, Integer> cache = new HashMap<List<Integer>, Integer>();
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size();

        // 过滤不需要计算的大礼包，只保留需要计算的大礼包
        List<List<Integer>> filterSpecial = new ArrayList<List<Integer>>();
        for (List<Integer> sp : special) {
            int totalCount = 0;
            int totalPrice = 0;
            for (int i = 0; i < n; i++) {
                totalCount += sp.get(i);
                totalPrice += sp.get(i)*price.get(i);
            }
            if (totalCount > 0 || totalPrice > sp.get(n)){
                filterSpecial.add(sp);
            }

        }
        return dfs(price, filterSpecial, needs,n);

    }
    public int dfs(List<Integer> price, List<List<Integer>> filterSpecial, List<Integer> curNeeds,int len){
        if (!cache.containsKey(curNeeds)){
            int minPrince = 0;
            for (int i = 0; i < len; i++) {
                minPrince += price.get(i) * curNeeds.get(i);  //不适用大礼包 单买的价格
            }
            for (List<Integer> sp : filterSpecial) {
                int bagPrince = sp.get(len);
                List<Integer> newNeeds = new ArrayList<>();
                for (int i = 0; i < len; i++) {
                    if (curNeeds.get(i) < sp.get(i)){
                        break;
                    }
                    newNeeds.add(curNeeds.get(i) - sp.get(i));
                }
                if (newNeeds.size() == len){
                    minPrince = Math.min(minPrince,
                            dfs(price, filterSpecial, newNeeds, len)+bagPrince);
                }
            }
            cache.put(curNeeds, minPrince);
        }
        return cache.get(curNeeds);
    }

    public static void main(String[] args) {
        N638 n638 = new N638();
    }
}
