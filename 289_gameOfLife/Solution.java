/*
LeetCode Problem No.289:    https://leetcode-cn.com/problems/game-of-life/
Author:                     zhangyixing1007
Idea:                       compound status
Time:                       1 ms, beat 43.60%
Space:                      38.1 MB, beat 11.11%
*/

class Solution {
    public void gameOfLife(int[][] board) {
        //2: live at the moment, dead next;
        //-1: dead at the moment, live next;
        if(board==null||board.length==0||board[0].length==0) return;
        int n=board.length;
        int m=board[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int count=0;
                for(int p=Math.max(0, i-1); p<=Math.min(n-1, i+1); p++){
                    for(int q=Math.max(0, j-1); q<=Math.min(m-1, j+1); q++){
                        if(board[p][q]>0) count++;
                    }
                }
                count-=board[i][j];
                if(board[i][j]==1){
                    if(count<2||count>3) board[i][j]=2;
                }else{
                    if(count==3) board[i][j]=-1;
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]==2) board[i][j]=0;
                else if(board[i][j]==-1) board[i][j]=1;
            }
        }        
        return;
    }
}
