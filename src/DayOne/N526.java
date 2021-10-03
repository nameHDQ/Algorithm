package DayOne;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hdq
 * @create 2021-08-16 11:12
 */
public class N526 {
    int num;
    List<Integer>[] match ;
    boolean[] isvis;
    public int countArrangement(int n) {
        match = new List[n+1];
        isvis = new boolean[n+1];
        for (int i = 0; i <= n; i++) {
            match[i] = new ArrayList<Integer>();
        }
        for (int i = 1; i <= n  ; i++) {
            for (int j = 1; j <= n ; j++) {
                if ((i%j == 0) || (j%i == 0)){
                    match[i].add(j);
                }
            }
        }
        backVis(1,n);
        return num;
    }
   public void backVis(int i,int n){
        if (i == n+1){
            num++;
            return;
        }
       for (int x: match[i]) {
           if (!isvis[x]){
               isvis[x] = true;
               backVis(i+1,n);
               isvis[x] = false;
           }
       }
        return;
    }

    public static void main(String[] args) {
        N526 test =new N526();
        System.out.println(test.countArrangement(2));
    }
}
