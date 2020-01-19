/*
LeetCode Problem No.79:     https://leetcode.com/problems/word-search/
Author:                     zhangyixing1007
Idea:                       classical recursion
Time:                       7 ms, beat 90.91%
Space:                      38.9 MB, beat 96.71%
*/

class Solution {
    public boolean exist(char[][] board, String word) {
        if (word==null||word.length()==0) return false;
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if (board[i][j]==word.charAt(0)){
                    board[i][j]='#';
                    if (find(board,word,i,j,1)) 
                        return true;   
                    board[i][j]=word.charAt(0);
                }
            }
        }
        return false;
    }
    
    boolean find(char[][] board, String word, int x, int y, int curr){
        if (curr==word.length())
            return true;
        for (int i=Math.max(x-1,0); i<Math.min(x+2,board.length); i++){
            if (board[i][y]==word.charAt(curr)){
                board[i][y]='#';
                if (find(board,word,i,y,curr+1)) 
                    return true;   
                board[i][y]=word.charAt(curr);
            }
        } 
        for (int j=Math.max(y-1,0); j<Math.min(y+2,board[0].length); j++){
            if (board[x][j]==word.charAt(curr)){
                board[x][j]='#';
                if (find(board,word,x,j,curr+1)) 
                    return true;   
                board[x][j]=word.charAt(curr);
            }
        }  
        return false;
    }
}
