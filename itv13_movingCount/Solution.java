/*
LeetCode Problem itv13：    https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
Author:                     zhangyixing1007
Idea:                       dfs
Time:                       1 ms, beat 87.30%
Space:                      36.6 MB, beat 100%
*/

class Solution {
    boolean sum(int m, int n){
        int ans=0;
        while(m!=0){
            ans+=m%10;
            m/=10;
        }
        while(n!=0){
            ans+=n%10;
            n/=10;
        }   
        return ans<=k;
    }
    public int movingCount(int m, int n, int k) {
        if(k==0) return 1;
        this.k=k;
        visited=new boolean[m][n];
        visited[0][0]=true;
        return movingCount(0,0);
    }
    int k;
    boolean[][] visited;
    int[] move=new int[]{1,-1};
    int movingCount(int m, int n){
        int ans=1;
        for(int i:move){
            int x=m+i, y=n;               
            if(x>=0&&x<visited.length&&y>=0&&y<visited[0].length
               &&!visited[x][y]&&sum(x,y)){
                visited[x][y]=true;
                ans+=movingCount(x,y);
            }
        }
        for(int i:move){
            int x=m, y=n+i;
            if(x>=0&&x<visited.length&&y>=0&&y<visited[0].length
               &&!visited[x][y]&&sum(x,y)){
                visited[x][y]=true;
                ans+=movingCount(x,y);            
            }
        }        
        return ans;
    }
}
