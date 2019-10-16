/*
LeetCode Problem No.221:    https://leetcode.com/problems/maximal-square/
Author:                     zhangyixing1007
Idea:                       recursion, brute force, faster than official answer
Time:                       5 ms, beat 98.28%
Space:                      40.2 MB, beat 95.89%
*/

class Solution
{
    public int maximalSquare(char[][] matrix)
    {
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                if (matrix[i][j] == '1') maxArea(i,j,1,matrix);
            }
        }
        return maxEdge*maxEdge;
    }
    
    private void maxArea(int i, int j, int edge, char[][] matrix)
    {
        if (i+edge>matrix.length||j+edge>matrix[0].length) return;
        if (matrix[i+edge-1][j+edge-1]=='0') return;
        for (int p = 0; p < edge; p++)
        {
            if (matrix[i+p][j+edge-1]=='0'||matrix[i+edge-1][j+p]=='0') return;
        }
        maxEdge = Math.max(maxEdge,edge);
        maxArea(i,j,edge+1,matrix);
    }
    
    int maxEdge = 0;
}
