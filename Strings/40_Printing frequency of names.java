import java.util.*;

public class NameCount {
    public static void main(String[] args) {
        String[] names = {"John", "Sara", "John", "Mike", "Sara", "John"};

        // Call the method to print name counts
        printNameCounts(names);
    }

    // Separate method to count and print names
    public static void printNameCounts(String[] names) {
        // TreeMap automatically sorts keys (names) in alphabetical order
        Map<String, Integer> count = new TreeMap<>();

        for (String name : names) {
            if (count.containsKey(name)) {
                count.put(name, count.get(name) + 1);
            } else {
                count.put(name, 1);
            }
        }

        for (String name : count.keySet()) {
            System.out.println(name + ": " + count.get(name));
        }
    }
}
