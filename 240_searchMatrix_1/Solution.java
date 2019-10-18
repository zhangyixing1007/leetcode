/*
LeetCode Problem No.240:    https://leetcode.com/problems/search-a-2d-matrix-ii/
Author:                     zhangyixing1007
Idea:                       easiest recursion, quite slow
Time:                       25 ms, beat 10.43%
Space:                      42.5 MB, beat 98.54%
*/

class Solution
{
    public boolean searchMatrix(int[][] matrix, int target)
    {
        if (matrix.length == 0||matrix[0].length==0) return false;
        if (matrix[0][0] > target) return false;
        else if (matrix[0][0] == target) return true;
        return search(matrix,target,2);
    }
    
    private boolean search(int[][] matrix, int target, int edge)
    {
        if (edge>Math.max(matrix.length,matrix[0].length)) return false;
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
        return search(matrix,target,edge+1);    
    }
}
