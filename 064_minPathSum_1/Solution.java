/*
LeetCode Problem No.64:     https://leetcode.com/problems/minimum-path-sum/
Author:                     zhangyixing1007
Idea:                       brutal recursion, no intermediate saving
Time:                       overtime
Space:                      unknown
*/

class Solution {
    public int minPathSum(int[][] grid) 
    {
        if (grid.length==0||grid[0].length==0) return 0;
        sum = new int[grid.length][grid[0].length];
        return path(0,0,grid);
    }
    private int[][] sum;
    private int path (int x, int y, int[][] grid)
    {
        if (x+1==sum.length&&y+1==sum[0].length) 
        {
            sum[x][y] = grid[x][y];
            return sum[x][y];
        }
        if (y+1>=sum[0].length&&x+1<sum.length)
        {
            sum[x+1][y] = path(x+1,y,grid);
            sum[x][y] = grid[x][y] + sum[x+1][y];
            return sum[x][y];
        }
        if (x+1>=sum.length&&y+1<sum[0].length)
        {
            sum[x][y+1] = path(x,y+1,grid);
            sum[x][y] = grid[x][y] + sum[x][y+1];
            return sum[x][y];
        }
        sum[x+1][y] = path(x+1,y,grid);
        sum[x][y+1] = path(x,y+1,grid);
        sum[x][y] = Math.min(grid[x][y]+sum[x+1][y],grid[x][y]+sum[x][y+1]);
        return sum[x][y];
    }
}
