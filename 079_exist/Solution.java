/*
LeetCode Problem No.79:     https://leetcode.com/problems/word-search/
Author:                     zhangyixing1007
Idea:                       classical recursion
Time:                       7 ms, beat 90.91%
Space:                      38.9 MB, beat 96.71%
*/

class Solution {
    public boolean exist(char[][] board, String word) {
        int n = word.length();
        if (n==0) return true;
        
        this.board = board;
        int now = 0;
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if (word.charAt(0) == board[i][j])
                {
                    char c = board[i][j];
                    this.board[i][j]='#';
                    if (find(i,j,word,now)==true) return true;
                    this.board[i][j] = c;
                }
            }
        }
        return false;
    }
    
    private char[][] board;
    
    private boolean find(int i, int j, String word, int now)
    {
        if (now==word.length()-1) return true;
        now ++;
        boolean result = false;
        if (i < board.length-1 && board[i+1][j]!= '#'
            && board[i+1][j] == word.charAt(now))
            {
                char c = board[i+1][j];
                this.board[i+1][j]='#';
                if (find(i+1,j,word,now)==true) return true;
                this.board[i+1][j] = c;
            }            


        
        if (i > 0 && board[i-1][j]!='#'
            && board[i-1][j] == word.charAt(now))
            {
                char c = board[i-1][j];
                this.board[i-1][j]='#';
                if (find(i-1,j,word,now)==true) return true;
                this.board[i-1][j] = c;
            }       
        
        if (j < board[0].length-1 && board[i][j+1]!='#'
            && board[i][j+1] == word.charAt(now))       
            {
                char c = board[i][j+1];
                this.board[i][j+1]='#';
                if (find(i,j+1,word,now) == true) return true;
                this.board[i][j+1] = c;
            }   
        
        if (j > 0 && board[i][j-1]!='#'
            && board[i][j-1] == word.charAt(now))
            {
                char c = board[i][j-1];
                this.board[i][j-1]='#';
                if (find(i,j-1,word,now) == true) return true;
                this.board[i][j-1] = c;
            }               
        return false;
    }
}
