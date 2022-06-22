package DayOne.hard;

import java.util.*;

/**
 * @author hdq
 * @create 2022-03-30 12:21
 */
public class N1606 {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        Queue<Integer>[] queue = new Queue[k];
        for (int i = 0; i < k; i++) {
            queue[i] = new ArrayDeque<>();
        }
        int n = arrival.length;
        int[] count = new int[k];
        for (int i = 0; i < n; i++) {
            int server = i % k;
            if (queue[server].isEmpty() || arrival[i] >= queue[server].peek()) {
                // 到达时间加上执行时间
                queue[server].offer(arrival[i] + load[i]);
                count[server]++;
            }else {
                int nextServer = (server + 1) % k;
                while (nextServer != server) {
                    // 服务器J处理I时刻到达的服务
                    if (queue[nextServer].isEmpty() || arrival[i] >= queue[nextServer].peek()) {
                        queue[nextServer].offer(arrival[i] + load[i]);
                        count[nextServer]++;
                        break;
                    }
                    nextServer = (nextServer + 1) % k;
                }
            }
        }
        int max = Arrays.stream(count).max().getAsInt();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        N1606 n1606 = new N1606();
        int[] arrival = {1,2,3,4,8,9,10};
        int[] load = {5,2,10,3,1,2,2};
        System.out.println(n1606.busiestServers(3, arrival, load));
    }
}
