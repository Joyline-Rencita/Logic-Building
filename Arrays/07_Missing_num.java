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
