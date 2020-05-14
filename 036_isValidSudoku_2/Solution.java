/*
LeetCode Problem No.036:    https://leetcode-cn.com/problems/valid-sudoku/
Author:                     zhangyixing1007
Idea:                       3 loops for row, column, box
Time:                       2 ms, beat 95.42%
Space:                      39.4 MB, beat 100%
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] record=new boolean[9];

        // check row
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                char c=board[i][j];
                if(c=='.') continue;
                if(record[c-'1']) return false;
                record[c-'1']=true;
            } 
            record=new boolean[9];
        }
        // check column
        for(int j=0; j<9; j++){
            for(int i=0; i<9; i++){
                char c=board[i][j];
                if(c=='.') continue;                
                if(record[c-'1']) return false;
                record[c-'1']=true;
            } 
            record=new boolean[9];
        }        
        // check box
        for(int i=0; i<9; i+=3){
            for(int j=0; j<9; j+=3){
                for(int p=i; p<i+3; p++){
                    for(int q=j; q<j+3; q++){
                        char c=board[p][q];
                        if(c=='.') continue;                
                        if(record[c-'1']) return false;
                        record[c-'1']=true;                        
                    }
                }
                record=new boolean[9];
            } 
        } 
        return true;
    }
}
