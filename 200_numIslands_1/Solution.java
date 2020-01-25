/*
LeetCode Problem No.200:    https://leetcode.com/problems/number-of-islands/
Author:                     zhangyixing1007
Idea:                       dfs
Time:                       2 ms, beat 98.37%
Space:                      41.1 MB, beat 85.59%
*/

class Solution
{
    public int numIslands(char[][] grid)
    {
        int island = 0;
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (grid[i][j] == '1')
                {dfs(grid,i,j);island++;}
            }
        }
        return island;
    }
    
    private void dfs (char[][] grid, int i, int j)
    {
        grid[i][j] = 0;
        if (i < grid.length-1 && grid[i+1][j] == '1')
            dfs(grid,i+1,j);
        if (j < grid[0].length-1 && grid[i][j+1] == '1')
            dfs(grid,i,j+1);
        if (i > 0 && grid[i-1][j] == '1')
            dfs(grid,i-1,j);
        if (j > 0 && grid[i][j-1] == '1')
            dfs(grid,i,j-1);                
    }
}
