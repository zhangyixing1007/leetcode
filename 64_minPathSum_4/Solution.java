/*
LeetCode Problem No.64:     https://leetcode.com/problems/minimum-path-sum/
Author:                     zhangyixing1007
Idea:                       no intermediate saving, operate on the original array, based on Version 2
Time:                       3 ms, beat 96.32%
Space:                      41.7 MB, beat 50.27%
*/

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m==0||n==0) return 0;
        
        // int[][] sum = new int[m][n];
        // sum[0][0]  = grid[0][0];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (i == 0 && j == 0) continue;
                if (i == 0) grid[i][j] = grid[i][j] + grid[i][j-1];
                else if (j == 0) grid[i][j] = grid[i][j] + grid[i-1][j];
                else grid[i][j] = grid[i][j-1]<grid[i-1][j]? grid[i][j-1]+grid[i][j]:grid[i-1][j]+grid[i][j];                
            }
        }
        return grid[m-1][n-1];
    }
}
