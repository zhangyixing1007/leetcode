/*
LeetCode Problem No.695:    https://leetcode-cn.com/problems/max-area-of-island/
Author:                     zhangyixing1007
Idea:                       union find
Time:                       4 ms, beat 42.92%
Space:                      40.1 MB, beat 91.67%
*/

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0) return 0;
        n=grid.length;
        m=grid[0].length;
        parents=new int[n*m];
        area=new int[n*m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    parents[j+i*m]=j+i*m;
                    area[j+i*m]=1;
                    add(i,j);
                }
            }
        }
        return ans;
    }
    int ans=0;
    int n, m;
    int[] parents;
    int[] area;

    void add(int i, int j){
        int id=j+i*m;
        ans=Math.max(ans,1);
        if(j-1>-1&&area[id-1]>0) link(id,id-1);      
        if(i-1>-1&&area[id-m]>0) link(id,id-m);
    }

    void link(int p, int q){    
        p=root(p);
        q=root(q);
        if(p>q) {int t=p; p=q; q=t;}
        if(p!=q){
            parents[p]=q;
            area[q]+=area[p];
            ans=Math.max(ans,area[q]);
        }
    }

    int root(int p){
        while(parents[p]!=p) p=parents[p];
        return p;
    }
}
