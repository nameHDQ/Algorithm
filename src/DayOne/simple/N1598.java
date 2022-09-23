package DayOne.simple;

public class N1598 {
    public int minOperations(String[] logs) {

        int dis = 0;

        for (String log : logs) {
            if (log.equals("../")){
                if (dis > 0){
                    dis = dis - 1;
                }
            }else if (log.equals("./")){
                continue;
            }else {
                dis++;
            }

        }
        return dis;
    }
}
