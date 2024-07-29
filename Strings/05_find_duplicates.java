import java.util.HashSet;
import java.util.Set;

public class Solution {

    // Instance method using two loops
    public void findDuplicatesUsingTwoLoops(String input) {
        char[] arr = input.toCharArray();
        int length = arr.length;

        System.out.print("Duplicate Characters using Two Loops: ");
        for (int i = 0; i < length; i++) {
            boolean isDuplicate = false;
            for (int j = i + 1; j < length; j++) {
                if (arr[i] == arr[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                boolean alreadyPrinted = false;
                for (int k = 0; k < i; k++) {
                    if (arr[i] == arr[k]) {
                        alreadyPrinted = true;
                        break;
                    }
                }
                if (!alreadyPrinted) {
                    System.out.print(arr[i] + " ");
                }
            }
        }
        System.out.println();
    }

    // Instance method using HashSet
    public void findDuplicatesUsingHashSet(String input) {
        Set<Character> characterSet = new HashSet<>();
        Set<Character> duplicateSet = new HashSet<>();

        System.out.print("Duplicate Characters using HashSet: ");
        for (char character : input.toCharArray()) {
            if (!characterSet.add(character)) {
                duplicateSet.add(character);
            }
        }

        for (Character character : duplicateSet) {
            System.out.print(character + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String input = "programming";

        // Create an instance of Solution
        Solution solution = new Solution();

        // Call methods using the instance
        solution.findDuplicatesUsingTwoLoops(input);
        solution.findDuplicatesUsingHashSet(input);
    }
}
