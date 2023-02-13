package weekcmplication.week323;

import java.util.HashMap;
import java.util.Map;

public class N3 {
    static class Allocator {
        int[] memo;

        public Allocator(int n) {
            memo = new int[n];
        }

        public int allocate(int size, int mID) {
            // 找到分配连续快的最后一个索引，然后判断之后是否有连续的空间0
            int count = 0;
            int endIndex = 0;
            for (int i = 0; i < memo.length; i++) {
                if (memo[i] == 0){
                    count++;
                }else {
                    count =0;
                }
                if (count >= size){
                    endIndex = i;
                    break;
                }
            }
            if (count < size){
                return -1;
            }else {
                for (int i = endIndex - count + 1; i <= endIndex; i++) {
                    memo[i] = mID;
                }
                return endIndex - size + 1;
            }
        }

        public int free(int mID) {
            int count = 0;
            for (int i = 0; i < memo.length; i++) {
                if (memo[i] == mID){
                    memo[i] = 0;
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Allocator allocator = new Allocator(10);
        allocator.allocate(1, 1);
        allocator.allocate(1, 2); // 最左侧的块的第一个下标是 1 。内存数组变为 [1,2, , , , , , , , ]。返回 1 。
        allocator.allocate(1, 3); // 最左侧的块的第一个下标是 2 。内存数组变为 [1,2,3, , , , , , , ]。返回 2 。
        allocator.free(2); // 释放 mID 为 2 的所有内存单元。内存数组变为 [1, ,3, , , , , , , ] 。返回 1 ，因为只有 1 个 mID 为 2 的内存单元。
        allocator.allocate(3, 4); // 最左侧的块的第一个下标是 3 。内存数组变为 [1, ,3,4,4,4, , , , ]。返回 3 。
        allocator.allocate(1, 1); // 最左侧的块的第一个下标是 1 。内存数组变为 [1,1,3,4,4,4, , , , ]。返回 1 。
        allocator.allocate(1, 1); // 最左侧的块的第一个下标是 6 。内存数组变为 [1,1,3,4,4,4,1, , , ]。返回 6 。
        allocator.free(1); // 释放 mID 为 1 的所有内存单元。内存数组变为 [ , ,3,4,4,4, , , , ] 。返回 3 ，因为有 3 个 mID 为 1 的内存单元。
        allocator.allocate(10, 2); // 无法找出长度为 10 个连续空闲内存单元的空闲块，所有返回 -1 。
        allocator.free(7); // 释放 mID 为 7 的所有内存单元。内存数组保持原状，因为不存在 mID 为 7 的内存单元。返回 0 。
    }
}
