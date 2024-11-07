import java.util.List;
import java.util.Arrays;

public class Solution {
    public static long minCost(int numProjects, List<Integer> projectId, List<Integer> bid) {
        // Array to store the minimum bid for each project
        long[] minBids = new long[numProjects];
        Arrays.fill(minBids, Long.MAX_VALUE);

        // Populate minimum bids for each project
        for (int i = 0; i < projectId.size(); i++) {
            int project = projectId.get(i);
            int currentBid = bid.get(i);
            minBids[project] = Math.min(minBids[project], currentBid);
        }

        // Calculate total minimum cost and check for unbid projects
        long totalCost = 0;
        for (long cost : minBids) {
            if (cost == Long.MAX_VALUE) {
                // If any project has no bids, return -1
                return -1;
            }
            totalCost += cost;
        }

        return totalCost;
    }
}
