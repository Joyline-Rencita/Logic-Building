import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
public static int minimumDistances(List<Integer> a) {
        // Create a map to store the first occurrence index of each element
        Map<Integer, Integer> indexMap = new HashMap<>();
        
        // Variable to store the minimum distance
        int minDistance = Integer.MAX_VALUE;
        
        // Iterate through the array
        for (int i = 0; i < a.size(); i++) {
            int currentElement = a.get(i);
            
            // If the element has been seen before, calculate the distance
            if (indexMap.containsKey(currentElement)) {
                int previousIndex = indexMap.get(currentElement);
                int distance = i - previousIndex;
                
                // Update the minimum distance if a smaller one is found
                minDistance = Math.min(minDistance, distance);
            }
            
            // Store the index of the current element
            indexMap.put(currentElement, i);
        }
        
        // If no pairs were found, return -1
        return (minDistance == Integer.MAX_VALUE) ? -1 : minDistance;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.minimumDistances(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
