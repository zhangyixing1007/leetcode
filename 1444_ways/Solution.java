/*
LeetCode Problem No.1444:   https://leetcode-cn.com/problems/number-of-ways-of-cutting-a-pizza/
Author:                     zhangyixing1007
Idea:                       dp
Time:                       12 ms, beat 100%
Space:                      37 MB, beat 100%
*/

class Solution {
    public int ways(String[] pizza, int k) {
        int N=1000000007;
        int row=pizza.length;
        int col=pizza[0].length();
        int[][] map=new int[row+1][col+1];
        for(int i=row-1; i>-1; i--){
            for(int j=col-1; j>-1; j--){
                map[i][j]=map[i+1][j]+map[i][j+1]-map[i+1][j+1];
                if(pizza[i].charAt(j)=='A') map[i][j]++;
            }
        }

        int[][][] dp=new int[k][row][col];
        dp[0][0][0]=1;
        for(int c=1; c<k; c++){
            for(int i=0; i<row; i++){
                for(int j=0; j<col; j++){
                    int count=0;
                    for(int m=0; m<i; m++){
                        int flag=map[m][j]-map[i][j];
                        if(flag!=0&&map[i][j]!=0){
                            count+=dp[c-1][m][j];
                            count%=N;
                        }
                    }
                    for(int m=0; m<j; m++){
                        int flag=map[i][m]-map[i][j];
                        if(flag!=0&&map[i][j]!=0){
                            count+=dp[c-1][i][m];
                            count%=N;
                        }
                    }                    
                    dp[c][i][j]=count%N;
                }
            }
        }

        int ans=0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                ans+=dp[k-1][i][j];
                ans%=N;
            }
        }
        return ans%N;
    }
}
