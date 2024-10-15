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

    /*
     * Complete the 'appendAndDelete' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     *  3. INTEGER k
     */

    public static String appendAndDelete(String s, String t, int k) {
        int m = s.length();
        int n = t.length();
        
        // Find the length of the common prefix
        int commonLength = 0;
        while (commonLength < Math.min(m, n) && s.charAt(commonLength) == t.charAt(commonLength)) {
            commonLength++;
        }

        // Calculate the total number of operations required
        int totalOperations = (m - commonLength) + (n - commonLength);

        // Check if we can perform exactly k operations
        if (totalOperations == k) {
            return "Yes";
        } else if (totalOperations < k) {
            // If we have extra operations left
            if ((k - totalOperations) % 2 == 0 || k >= m + n) {
                return "Yes";
            }
        }

        return "No";
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String t = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
