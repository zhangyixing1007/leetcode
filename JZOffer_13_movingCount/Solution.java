/*
JZOffer Problem No.13:      https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/submissions/
Author:                     zhangyixing1007
Idea:                       dfs
Time:                       1 ms, beat 85.32%
Space:                      35.3 MB, beat 99.51%
*/

class Solution {
    public int movingCount(int m, int n, int k) {
        visited=new boolean[m][n];
        this.m=m; this.n=n;
        return dfs(0, 0, k);
    }
    int dfs(int x, int y, int k){
        if(!canVisit(x, y, k) || visited[x][y]) return 0;
        int ans=1;
        visited[x][y]=true;
        ans+=dfs(x+1, y, k);
        ans+=dfs(x, y+1, k);
        return ans;
    }
    boolean[][] visited;
    int m, n;
    boolean canVisit(int x, int y, int k){
        if(x<0 || x>=m || y<0 || y>=n) return false;
        int sum=0;
        while(x!=0){
            sum+=x%10;
            x/=10;
        }
        while(y!=0){
            sum+=y%10;
            y/=10;
        }
        return sum<=k;
    }
}
