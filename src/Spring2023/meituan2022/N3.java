package Spring2023.meituan2022;

import java.util.PriorityQueue;
import java.util.Scanner;

public class N3 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String num1 = in.nextLine();
        int num = Integer.parseInt(num1);
        while(num-- > 0){
            String len1 = in.nextLine();
            int len = Integer.parseInt(len1);
            int[] loc = new int[len];
            String strNum = in.nextLine();
            for(int i = 0; i < len ; i++){
                loc[i] = (strNum.charAt(i) - '0');
            }
            PriorityQueue<Integer> single = new PriorityQueue<>();
            PriorityQueue<Integer> db = new PriorityQueue<>();
            for(int i = 0; i < len ; i++){
                if(loc[i] == 1){
                    single.add(i);
                }
                if(loc[i] == 0){
                    db.add(i);
                }
            }
            String n = in.nextLine();
            String str = in.nextLine();
            for(int i = 0; i < str.length() ; i++){
                if(str.charAt(i) == 'M'){
                    // male
                    if(!single.isEmpty()){
                        int index = single.poll();
                        System.out.println(index);
                    }else{
                        int index = db.poll();
                        single.add(index);
                        System.out.println(index);
                    }
                }else{
                    // female
                    if(!db.isEmpty()){
                        int index = db.poll();
                        single.add(index);
                        System.out.println(index);
                    }else{
                        int index = single.poll();
                        System.out.println(index);
                    }
                }
            }

        }
    }
}
