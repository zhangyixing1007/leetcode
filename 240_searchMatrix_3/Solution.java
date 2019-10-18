/*
LeetCode Problem No.240:    https://leetcode.com/problems/search-a-2d-matrix-ii/
Author:                     zhangyixing1007
Idea:                       start from the leftest and downest corner, if larger than target, move to right, otherwise, up
Time:                       7 s, beat 98.74%
Space:                      42.7 MB, beat 97.30%
*/

class Solution
{
    public boolean searchMatrix(int[][] matrix, int target)
    {
        if (matrix==null||matrix.length==0|| matrix[0].length==0) return false;
        int row = matrix.length-1;
        int col = 0;
        
        while (true)
        {
            if (row<0||col>matrix[0].length-1) return false;
            if (matrix[row][col] > target) {row--;}
            else if (matrix[row][col] < target) {col++;}
            else {return true;}
        }
    }
}
