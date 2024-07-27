Given an array of strings arr[] of length n representing non-negative integers, arrange them in a manner, such that, after concatenating them in order, it results in the largest possible number. Since the result may be very large, return it as a string.

Examples:

Input: n = 5, arr[] =  {"3", "30", "34", "5", "9"}
Output: "9534330"
Explanation: Given numbers are  {"3", "30", "34", "5", "9"}, the arrangement "9534330" gives the largest value.
Input: n = 4, arr[] =  {"54", "546", "548", "60"}
Output: "6054854654"
Explanation: Given numbers are {"54", "546", "548", "60"}, the arrangement "6054854654" gives the largest value.
Expected Time Complexity: O(n*log(n) ).
Expected Auxiliary Space: O(n).
Constraints:
1 ≤ n ≤ 105
0 ≤ arr[i] ≤ 1018
The sum of all the elements of the array is greater than 0.

Solution : 

import java.util.Arrays;

class Solution {
    String printLargest(int n, String[] arr) {
        // Sort the array with a custom comparator
        // The comparator concatenates two strings in both possible orders (x+y and y+x)
        // and compares them to ensure the larger concatenation comes first.
        Arrays.sort(arr, (x, y) -> (y + x).compareTo(x + y));
        
        // Create a StringBuilder to build the final largest number from the sorted array
        StringBuilder largestNumber = new StringBuilder();
        for (String str : arr) {
            largestNumber.append(str);
        }
        
        // Edge case: if the largest number starts with '0', the result should be '0'
        // This handles cases where the array consists of only zeros.
        if (largestNumber.charAt(0) == '0') {
            return "0";
        }
        
        // Return the final concatenated largest number as a string
        return largestNumber.toString();
    }
}
