/*
LeetCode Problem No.695:    https://leetcode-cn.com/problems/max-area-of-island/
Author:                     zhangyixing1007
Idea:                       dfs
Time:                       2 ms, beat 100%
Space:                      40.1 MB, beat 91.67%
*/

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0) return 0;
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        this.grid=grid;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    ans=Math.max(ans,dfs(i,j));
                }
            }
        }
        return ans;
    }

    int[][] grid;

    int dfs(int i, int j){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]==0)return 0;
        grid[i][j]=0;
        int ans=1;
        ans+=dfs(i-1,j);
        ans+=dfs(i+1,j);
        ans+=dfs(i,j-1);
        ans+=dfs(i,j+1);
        return ans;
    }
}
