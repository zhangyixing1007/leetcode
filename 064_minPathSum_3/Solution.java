/*
LeetCode Problem No.64:     https://leetcode.com/problems/minimum-path-sum/
Author:                     zhangyixing1007
Idea:                       2-fold iteration, 1-D array as intermediate saving
Time:                       2 ms, beat 99.72%
Space:                      42.2 MB, beat 44.00%
*/

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m==0||n==0) return 0;
        
        int[] sum = new int[n];
        System.arraycopy(grid[0],0,sum,0,n);
        for (int j = 1; j < n; j++){
            sum[j] += sum[j-1];
        }
        for (int i = 1; i < m; i++){
            sum[0] = sum[0] + grid[i][0];
            for (int j = 1; j < n; j++){
                sum[j] = sum[j-1]<sum[j]? (sum[j-1] + grid[i][j]) : (sum[j] + grid[i][j]);
            }
        }
        return sum[n-1];
    }
}
