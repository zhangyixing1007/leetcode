/*
LeetCode Problem No.64:     https://leetcode.com/problems/minimum-path-sum/
Author:                     zhangyixing1007
Idea:                       2-fold iteration, 2-D array as intermediate saving
Time:                       4 ms, beat 85.06%
Space:                      39.8 MB, beat 85.43%
*/

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length; 
        int n = grid[0].length;
        if (m==0||n==0) return 0;
        
        int[][] sum = new int[m][n];
        sum[0][0]  = grid[0][0];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 && j == 0) continue;
                if (i == 0) sum[i][j] = grid[i][j] + sum[i][j-1]; 
                else if (j == 0) sum[i][j] = grid[i][j] + sum[i-1][j];
                else sum[i][j] = sum[i][j-1]<sum[i-1][j]? sum[i][j-1]+grid[i][j]:sum[i-1][j]+grid[i][j];                
            }
        }
        return sum[m-1][n-1];
    }
}
