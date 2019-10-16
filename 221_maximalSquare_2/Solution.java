/*
LeetCode Problem No.221:    https://leetcode.com/problems/maximal-square/
Author:                     zhangyixing1007
Idea:                       dynamic programming, 2-d array as saving
Time:                       6 ms, beat 95.16%
Space:                      40.9 MB, beat 88.65%
*/

class Solution
{
    public int maximalSquare(char[][] matrix)
    {
        int row = matrix.length;
        int col = row >0 ? matrix[0].length:0;
        int[][] dp = new int[row+1][col+1];
        int maxEdge = 0;
        for (int i = 1; i <= row; i++)
        {
            for (int j = 1; j <= col; j++)
            {
                if (matrix[i-1][j-1]=='1')
                {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1;
                    maxEdge = Math.max(maxEdge,dp[i][j]);
                }
            }
        }
        return maxEdge*maxEdge;
    }
}
