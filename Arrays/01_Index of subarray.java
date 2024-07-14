Indexes of Subarray Sum
Difficulty: MediumAccuracy: 16.5%Submissions: 1.6MPoints: 4
Given an unsorted array arr of size n that contains only non negative integers, find a sub-array (continuous elements) that has sum equal to s. You mainly need to return the left and right indexes(1-based indexing) of that subarray.
In case of multiple subarrays, return the subarray indexes which come first on moving from left to right. If no such subarray exists return an array consisting of element -1.

Examples:

Input: arr[] = [1,2,3,7,5], n = 5, s = 12
Output: 2 4
Explanation: The sum of elements from 2nd to 4th position is 12.
Input: arr[] = [1,2,3,4,5,6,7,8,9,10], n = 10, s = 15,
Output: 1 5
Explanation: The sum of elements from 1st to 5th position is 15.
Input: arr[] = [7,2,1], n = 3, s = 2
Output: 2 2
Explanation: The sum of elements from 2nd to 2nd position is 2.
Input: arr[] = [5,3,4], n = 3, s = 2
Output: -1
Explanation: There is no subarray with sum 2
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:

0 <= arr[i] <= 109
1 <= n <= 105
0 <= s <= 109

  Solution:

Logic:  Sliding window or 2 pointer approach

Initialize two pointers, start and end, both set to the beginning of the array.
Use a variable current_sum to keep track of the sum of the current subarray.
Move the end pointer to expand the window by adding the value of the current element to current_sum.
If current_sum exceeds the target sum 
𝑠
s, move the start pointer to the right to reduce the window size until current_sum is less than or equal to 
𝑠
s.
If current_sum equals 
𝑠
s, return the current indices adjusted for 1-based indexing.
If the end of the array is reached and no such subarray is found, return [-1].

CODE:

class Solution {
    public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> result = new ArrayList<>();
        int start = 0;
        int currentSum = 0;

        for (int end = 0; end < n; end++) {
            currentSum += arr[end];

            while (currentSum > s && start <= end) {
                currentSum -= arr[start];
                start++;
            }

            if (currentSum == s) {
                result.add(start + 1); // converting to 1-based index
                result.add(end + 1); // converting to 1-based index
                return result;
            }
        }

        result.add(-1); // No subarray found
        return result;
    }
}

