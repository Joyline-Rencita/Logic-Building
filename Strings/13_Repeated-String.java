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
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    public static long repeatedString(String s, long n) {
        // Count occurrences of 'a' in the input string
        long countAInS = s.chars().filter(ch -> ch == 'a').count();

        // Calculate number of complete repetitions of s in the first n characters
        long fullRepeats = n / s.length();

        // Count 'a's from the complete repetitions
        long totalCountA = countAInS * fullRepeats;

        // Calculate remaining characters
        long remainingChars = n % s.length();

        // Count 'a's in the remaining substring
        for (int i = 0; i < remainingChars; i++) {
            if (s.charAt(i) == 'a') {
                totalCountA++;
            }
        }

        return totalCountA; // Return the total count of 'a'
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
