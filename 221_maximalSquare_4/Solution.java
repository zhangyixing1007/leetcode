/*
LeetCode Problem No.221:    https://leetcode.com/problems/maximal-square/
Author:                     zhangyixing1007
Idea:                       dynamic programming, 1-d array as saving
Time:                       6 ms, beat 87.83%
Space:                      41.1 MB, beat 89.62%
*/

class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix.length==0? 0:matrix[0].length;
        int[] dp = new int[col+1];
        int ans = 0;
        for (int i = 1; i < row+1; i++){
            int prev = 0;
            for (int j = 1; j < col+1; j++){
                int temp = dp[j];
                if (matrix[i-1][j-1]=='1'){
                    dp[j] = Math.min(Math.min(dp[j-1],dp[j]),prev)+1;
                    ans = Math.max(ans,dp[j]);
                } else {dp[j] = 0;}
                prev = temp;
            }
        }            
        return ans*ans;
    }
}
