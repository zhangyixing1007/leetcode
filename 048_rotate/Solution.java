/*
LeetCode Problem No.48:    https://leetcode.com/problems/rotate-image/
Author:                    zhangyixing1007
Idea:                      cut the matrix into 4 parts, use two layers of loops
Time:                      0 ms, beat 100%
Space:                     36.2MB, beat 58.92%
*/


class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n+1)/2; i++){
            for (int j = 0; j < n/2; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1]; 
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = tmp;
            }
        }
    }
}
