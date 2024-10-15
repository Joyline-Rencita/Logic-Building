import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.joining;


class Result {
    /*
     * Complete the 'serviceLane' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY width
     *  3. 2D_INTEGER_ARRAY cases
     */
    public static List<Integer> serviceLane(int n, List<Integer> width, List<List<Integer>> cases) {
        List<Integer> results = new ArrayList<>();

        // Iterate through each case
        for (List<Integer> caseEntry : cases) {
            int entryIndex = caseEntry.get(0);
            int exitIndex = caseEntry.get(1);
            
            // Find the minimum width in the range [entryIndex, exitIndex]
            int minWidth = Integer.MAX_VALUE;
            for (int i = entryIndex; i <= exitIndex; i++) {
                minWidth = Math.min(minWidth, width.get(i)); // Use the width from the width array
            }
            
            // Add the result for this case
            results.add(minWidth);
        }

        return results; // Return the list of results
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(firstMultipleInput[0]);
        int t = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> width = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<List<Integer>> cases = new ArrayList<>();

        IntStream.range(0, t).forEach(i -> {
            try {
                cases.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        // Pass the width list to the serviceLane function
        List<Integer> result = Result.serviceLane(n, width, cases);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
                + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
