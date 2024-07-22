Merge Without Extra Space
Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order. Merge them in sorted order without using any extra space. Modify arr1 so that it .
contains the first N elements and modify arr2 so that it contains the last M elements.

Example 1:

Input: 
n = 4, arr1[] = [1 3 5 7] 
m = 5, arr2[] = [0 2 6 8 9]
Output: 
arr1[] = [0 1 2 3]
arr2[] = [5 6 7 8 9]
Explanation:
After merging the two  non-decreasing arrays, we get : 0 1 2 3 5 6 7 8 9.

SOLUTION :
class Solution
{
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) {
        // Declare 2 pointers:
        int left = n - 1;  // pointer for arr1
        int right = 0;     // pointer for arr2

        // Swap the elements until arr1[left] is smaller than arr2[right]:
        while (left >= 0 && right < m) {
            if (arr1[left] > arr2[right]) {
                // Swap arr1[left] and arr2[right]
                long temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;
            } else {
                break;
            }
        }

        // Sort arr1[] and arr2[] individually:
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
