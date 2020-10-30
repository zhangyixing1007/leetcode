/*
LeetCode Problem No.0463:   https://leetcode-cn.com/problems/island-perimeter/
Author:                     zhangyixing1007
Idea:                       iteration for inner and outer edges
Time:                       7 ms, beat 97.53%
Space:                      39.8 MB, beat 43.12%
*/

class Solution {
    public int islandPerimeter(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0) return 0;
        int ans=0;
        int n=grid.length, m=grid[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i+1<n && grid[i][j]+grid[i+1][j]==1){
                    ans++;
                }
                if(j+1<m && grid[i][j]+grid[i][j+1]==1){
                    ans++;
                }
            }
        }
        for(int i=0; i<n; i++){
            if(grid[i][0]==1) ans++;
            if(grid[i][m-1]==1) ans++;
        }
        for(int j=0; j<m; j++){
            if(grid[0][j]==1) ans++;
            if(grid[n-1][j]==1) ans++;
        }
        return ans;
    }
}
