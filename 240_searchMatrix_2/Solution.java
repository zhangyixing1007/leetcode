/*
LeetCode Problem No.240:    https://leetcode.com/problems/search-a-2d-matrix-ii/
Author:                     zhangyixing1007
Idea:                       iteration, still slow but faster than easiest recursion
Time:                       16 ms, beat 21.33%
Space:                      43.4 MB, beat 95.26%
*/

class Solution
{
    public boolean searchMatrix(int[][] matrix, int target)
    {
        if (matrix.length == 0||matrix[0].length==0) return false;
        if (matrix[0][0] > target) return false;
        else if (matrix[0][0] == target) return true;
        int edge = 2;
        while (edge<=Math.max(matrix.length,matrix[0].length))
        {
            if (edge <= matrix.length)
            {
                for (int i = 0; i < Math.min(edge,matrix[0].length); i++)
                {
                    if (matrix[edge-1][i] == target) return true;                
                }
            }

            if (edge <= matrix[0].length)
            {
                for (int i = 0; i < Math.min(edge,matrix.length); i++)
                {
                    if (matrix[i][edge-1] == target) return true;                
                }
            }  
            edge++;
        }
        return false;
    }
}
