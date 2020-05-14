/*
LeetCode Problem No.073:    https://leetcode-cn.com/problems/set-matrix-zeroes/
Author:                     zhangyixing1007
Idea:                       mark 1st ele in corresponding row and col, two extra boolean for Row 0 and Col 0
Time:                       1 ms, beat 99.97%
Space:                      41 MB, beat 100%
*/

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean row=false;
        boolean column=false;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==0){
                    if(j!=0) matrix[0][j]=0;
                    else column=true;
                    if(i!=0) matrix[i][0]=0;
                    else row=true;
                }
            }
        }
        for(int i=1; i<matrix.length; i++){
            if(matrix[i][0]==0){
                for(int j=1; j<matrix[0].length; j++) matrix[i][j]=0;
            }
        }   
        for(int j=1; j<matrix[0].length; j++){
            if(matrix[0][j]==0){
                for(int i=1; i<matrix.length; i++) matrix[i][j]=0;
            }
        }   
        if(row){
            for(int j=0; j<matrix[0].length; j++)
                matrix[0][j]=0;         
        }   
        if(column){
            for(int i=0; i<matrix.length; i++) matrix[i][0]=0;             
        }      
    }
}
