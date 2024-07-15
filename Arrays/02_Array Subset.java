Given two arrays: a1[0..n-1] of size n and a2[0..m-1] of size m, where both arrays may contain duplicate elements. The task is to determine whether array a2 is a subset of array a1. It's important to note that both arrays can be sorted or unsorted. Additionally, each occurrence of a duplicate element within an array is considered as a separate element of the set.

Example 1:
Input:
a1[] = {11, 7, 1, 13, 21, 3, 7, 3}
a2[] = {11, 3, 7, 1, 7}
Output:
Yes
Explanation:
a2[] is a subset of a1[]

Example 2:
Input:
a1[] = {1, 2, 3, 4, 4, 5, 6}
a2[] = {1, 2, 4}
Output:
Yes
Explanation:
a2[] is a subset of a1[]

SOLUTION:

class Compute {
    public String isSubset(long a1[], long a2[], long n, long m) {
        
        // Create a HashMap to store the frequency of elements in the first array
        Map<Long, Integer> map = new HashMap<> ();
        
        // Populate the HashMap with elements from the first array (a1)
        for (long x : a1) {
            if (map.containsKey(x)) {
                // If the element is already in the map, increment its count
                map.put(x, map.get(x) + 1);
            } else {
                // If the element is not in the map, add it with a count of 1
                map.put(x, 1);
            }
        }

        // Check if all elements of the second array (a2) are present in the map
        for (long x : a2) {
            if (map.containsKey(x)) {
                // If the element is present, check its count
                if (map.get(x) == 1) {
                    // If the count is 1, remove the element from the map
                    map.remove(x);
                } else {
                    // If the count is more than 1, decrement its count
                    map.put(x, map.get(x) - 1);
                }
            } else {
                // If the element is not present in the map, return "No"
                return "No";
            }
        }

        // If all elements of a2 are accounted for, return "Yes"
        return "Yes";
    }
}

Explanation : 

The code begins by creating a HashMap to store the frequency of each element in the first array (`a1`). This setup allows for efficient look-up and management of 
element counts. A `for-each` loop then populates the HashMap by iterating through `a1`, where each element's count is either incremented if it already exists in 
the map or initialized to 1 if it does not. Next, another `for-each` loop iterates through the second array (`a2`) to verify if each element is present in the
HashMap with sufficient count. For each element in `a2`, the code checks the map: if the element is found, its count is decremented, and if the count becomes zero, 
the element is removed from the map. If an element from `a2` is not found in the map, the function immediately returns "No", indicating that `a2` is not a subset of
`a1`. If the loop completes and all elements in `a2` are accounted for, the function returns "Yes", confirming that `a2` is a subset of `a1`. This approach 
efficiently determines subset inclusion by leveraging the HashMap for quick element look-up and count tracking.
