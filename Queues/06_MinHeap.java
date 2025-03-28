import java.util.PriorityQueue;
import java.util.List;

public class Solution {
    public static int minPower(List<Integer> cells) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(cells);
        int totalPower = 0;

        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            int mergePower = first + second;
            totalPower += mergePower;
            minHeap.offer(mergePower);
        }

        return totalPower;
    }
}
