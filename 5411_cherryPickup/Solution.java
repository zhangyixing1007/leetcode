/*
LeetCode Problem No.5411:   https://leetcode-cn.com/problems/cherry-pickup-ii/
Author:                     zhangyixing1007
Idea:                       dp, int[rows][cols][cols]
Time:                       12 ms, beat xx%
Space:                      40.2 MB, beat xx%
*/

class Solution {
    public int cherryPickup(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int[][][] dp=new int[rows][cols][cols];
        dp[0][0][cols-1]=grid[0][0]+grid[0][cols-1];
        for(int i=1; i<rows; i++){
            int limit=Math.min(i, cols-1);
            for(int j1=0; j1<=limit; j1++){
                for(int j2=cols-limit-1; j2<cols; j2++){
                    int max=0;
                    for(int d1=Math.max(j1-1,0); 
                        d1<Math.min(j1+2, cols); d1++){
                        for(int d2=Math.max(j2-1,0); 
                            d2<Math.min(j2+2, cols); d2++){
                            max=Math.max(max, dp[i-1][d1][d2]);
                        }
                    }
                    dp[i][j1][j2]=max+ (j1==j2? grid[i][j1]:grid[i][j1]+grid[i][j2]);
                }
            }
        }
        int ans=0;
        for(int i=0; i<cols; i++){
            for(int j=0; j<cols; j++){
                ans=Math.max(ans, dp[rows-1][i][j]);
            }
        }
        return ans;
    }
}
