package weekcmplication.week324;

import javax.swing.*;
import java.util.*;

public class N3 {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        Map<Integer, Integer> inEdge = new HashMap<>();
        int[] oddPoint = new int[4];
        Map<Integer, Set<Integer>> outEdges = new HashMap<>();
        for (List<Integer> edge : edges) {
            int x = edge.get(0);
            int y = edge.get(1);
            inEdge.put(x, inEdge.getOrDefault(x, 0) + 1);
            Set<Integer> tempX = outEdges.getOrDefault(x, new HashSet<>());
            tempX.add(y);
            outEdges.put(x, tempX);
            inEdge.put(y, inEdge.getOrDefault(y, 0) + 1);
            Set<Integer> tempY = outEdges.getOrDefault(y, new HashSet<>());
            tempY.add(x);
            outEdges.put(y, tempY);
        }
        int count = 0;
        int index = 0;
        for (Integer key : inEdge.keySet()) {
            if (inEdge.get(key) % 2 != 0){
                count++;
                if (count > 4){
                    return false;
                }
                oddPoint[index++] = key;
            }
        }
        if (count == 0) {
            return true;
        }
        if (count == 3 || count == 1){
            return false;
        }
        if (count == 2){
            int first = oddPoint[0];
            int Second = oddPoint[1];
            Set<Integer> set = outEdges.get(first);
            if (!set.contains(Second)){
                return true;
            }
            for (int i = 1; i <= n && i != first && i != Second; i++) {
                if (!outEdges.containsKey(i)){
                    return true;
                }else {
                    Set<Integer> temp = outEdges.get(i);
                    if (!temp.contains(first) && !temp.contains(Second)){
                        return true;
                    }
                }
            }
            return false;
        }
        if (count == 4){
            int first = oddPoint[0];
            for (int i = 1; i < oddPoint.length; i++) {
                Set<Integer> set = outEdges.get(first);
                if (set.contains(oddPoint[i])){
                    continue;
                }
                if (i == 1){
                    Set<Integer> temp = outEdges.get(oddPoint[2]);
                    if (!temp.contains(oddPoint[3])){
                        return true;
                    }
                }else if (i == 2){
                    Set<Integer> temp = outEdges.get(oddPoint[1]);
                    if (!temp.contains(oddPoint[3])){
                        return true;
                    }
                }else {
                    Set<Integer> temp = outEdges.get(oddPoint[1]);
                    if (!temp.contains(oddPoint[2])){
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<>();
        List<Integer> a1 = new ArrayList<>();
        a1.add(1);
        a1.add(2);
        List<Integer> a2 = new ArrayList<>();
        a2.add(3);
        a2.add(4);
        edges.add(a1);
        edges.add(a2);
        new N3().isPossible(4,edges);
    }
}
