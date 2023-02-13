package DayOne.medium;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class N861 {
    public int matrixScore(int[][] grid) {
        int ans = 0;
        int m =grid.length;
        int n = grid[0].length;
        // 第一列只能全是1
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0){
                for (int j = 0; j < n; j++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }
        ans += m * (1 << (n - 1));
        for (int j = 1; j < n; j++) {
            int count1 = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1){
                    count1++;
                }
            }
            count1 = Math.max(count1, m - count1);

            ans += count1 * (1 << (n - j - 1));
        }

        return ans;
    }

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition first = lock.newCondition();
        Condition second = lock.newCondition();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                lock.lock();
                try {
                    first.await();
                    System.out.println('a');
                    second.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                lock.unlock();
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                lock.lock();
                    try {
                        second.await();
                        System.out.println('b');
                        first.signal();

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                lock.unlock();

            }
        }).start();
        lock.lock();
        first.signal();
        lock.unlock();
    }
}
