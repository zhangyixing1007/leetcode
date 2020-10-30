/*
LeetCode Problem No.0463:   https://leetcode-cn.com/problems/island-perimeter/
Author:                     zhangyixing1007
Idea:                       iteration for upper and left boundary
Time:                       7 ms, beat 97.52%
Space:                      39.9 MB, beat 26.79%
*/

class Solution{
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int row = 0; row <grid.length; row++){
            for (int col = 0; col <grid[0].length; col++){
                if (grid[row][col]==1){
                    if (0 == row || 0 == grid[row - 1][col]) // 前一个不是
                        res += 2;
                    if (0 == col || 0 == grid[row][col - 1]) // 上一行不是
                        res += 2;
                }
            }
        }
        return res;
    }
}
