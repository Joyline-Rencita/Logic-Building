import java.util.Arrays;
import java.util.Scanner;

public class Main {

    // Approach 1: Sort a string using inbuilt function
    public String sortStringWithInbuilt(String str) {
        // Convert the string to a character array
        char[] charArray = str.toCharArray();
        
        // Sort the character array using Arrays.sort()
        Arrays.sort(charArray);
        
        // Convert the sorted character array back to a string
        return new String(charArray);
    }

    // Approach 2: Sort a string without using inbuilt function (Bubble Sort)
    public String sortStringWithoutInbuilt(String str) {
        // Convert the string to a character array
        char[] charArray = str.toCharArray();
        
        // Implement Bubble Sort
        int n = charArray.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (charArray[j] > charArray[j + 1]) {
                    // Swap charArray[j] and charArray[j + 1]
                    char temp = charArray[j];
                    charArray[j] = charArray[j + 1];
                    charArray[j + 1] = temp;
                }
            }
        }
        
        // Convert the sorted character array back to a string
        return new String(charArray);
    }

    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        
        System.out.println("Enter the string:");
        if (sc.hasNextLine()) {
            String input = sc.nextLine();

            // Approach 1: Using inbuilt function
            String sortedStringWithInbuilt = main.sortStringWithInbuilt(input);
            System.out.println("Sorted String (With Inbuilt Function): " + sortedStringWithInbuilt);

            // Approach 2: Without using inbuilt function
            String sortedStringWithoutInbuilt = main.sortStringWithoutInbuilt(input);
            System.out.println("Sorted String (Without Inbuilt Function): " + sortedStringWithoutInbuilt);
        } else {
            System.out.println("No input found.");
        }

        sc.close();
    }
}
