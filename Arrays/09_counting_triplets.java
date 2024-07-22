Given an array Arr consisting of N distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.
 
Example 1:
Input: 
N = 4 
arr[] = {1, 5, 3, 2}
Output: 2 
Explanation: There are 2 triplets:
 1 + 2 = 3 and 3 + 2 = 5

SOLUTION :
  
class Solution {
    int countTriplet(int arr[], int n) {
        Arrays.sort(arr);     // Sort the array
        int count = 0;
        // Iterate through the array from the last element to the third element
        for (int i = n - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                int sum = arr[left] + arr[right];
                if (sum == arr[i]) {
                    count++;
                    left++;
                    right--;
                } 
                else if (sum < arr[i]) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return count;
    }
}
