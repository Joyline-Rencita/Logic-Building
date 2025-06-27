There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner 
(i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
The test cases are generated so that the answer will be less than or equal to 2 * 109.

//*************************************

Solution :

class Solution {
    public int uniquePaths(int m, int n) {
        
        var f = new int[m][n];                          // Create a 2D array to store the number of unique paths to each cell   
        f[0][0] = 1;                                    // Base case: there is only one way to reach the starting cell (top-left)

        for (int i = 0; i < m; ++i) {                   // Iterate through each cell in the grid
            for (int j = 0; j < n; ++j) {

                if (i > 0) {                             // If not in the first row, add the number of ways to reach the cell from the top
                    f[i][j] += f[i - 1][j];
                }

                if (j > 0) {                              // If not in the first column, add the number of ways to reach the cell from the left
                    f[i][j] += f[i][j - 1];
                }
            }
        }
        return f[m - 1][n - 1];                         // The answer is the number of unique paths to reach the bottom-right cell
    }
}
