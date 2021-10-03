package DayOne;

import jdk.nashorn.internal.ir.IfNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hdq
 * @create 2021-08-29 12:17
 */
public class N77 {
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> combine(int n, int k) {
        for (int i = 1; i <= n; i++) {
            temp.add(i);
            bin(i,n,1,k);
            temp.remove(temp.size()-1);
        }

        return ans;
    }
    public void bin(int i,int n,int index,int k){
        if (index == k){
            List<Integer> now = new LinkedList<>();
            now.addAll(temp);
            ans.add(now);
            return;
        }
        for (int j = i+1; j <= n; j++) {
            temp.add(j);
            bin(j,n,index+1,k);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        N77 n77 = new N77();
        List<List<Integer>> combine = n77.combine(1, 1);
        for (List<Integer> l :
                combine) {
            for (int i :
                    l) {
                System.out.println(i);
            }
        }
    }
}
