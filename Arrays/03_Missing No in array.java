Given an array of size n-1 such that it only contains distinct integers in the range of 1 to n. Return the missing element

Input: n = 5, arr[] = [1,2,3,5]
Output: 4
Explanation : All the numbers from 1 to 5 are present except 4. 

CODE : 
// User function Template for Java
class Solution {
    // Note that the size of the array is n-1
    int missingNumber(int n, int arr[]) {
        // Initialize x1 with the first element of the array
        int x1 = arr[0];
        // Initialize x2 with 1, since we need to XOR all numbers from 1 to n
        int x2 = 1;

        // XOR all elements in the array
        for (int i = 1; i < n - 1; i++) {
            x1 = x1 ^ arr[i];
        }

        // XOR all numbers from 1 to n
        for (int i = 2; i <= n; i++) {
            x2 = x2 ^ i;
        }

        // The missing number is the XOR of x1 and x2
        return (x1 ^ x2);
    }
}

Explanation:
Initialize two variables, x1 and x2, to store the XOR of all elements in the array and the XOR of all integers from 1 to n, respectively. The first loop XORs all 
elements of the array, while the second loop XORs all integers from 1 to n. The missing number is determined by XORing the results of x1 and x2, as the XOR 
operation will cancel out all duplicate numbers and leave only the missing number.
