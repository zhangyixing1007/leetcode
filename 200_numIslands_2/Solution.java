/*
LeetCode Problem No.200:    https://leetcode.com/problems/number-of-islands/
Author:                     zhangyixing1007
Idea:                       Union Find
Time:                       6 ms, beat 27.32%
Space:                      41.3 MB, beat 21.49%
*/

class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0)
            return 0;
        int n=grid.length, m=grid[0].length;
        UnionFind uf=new UnionFind(grid);        
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if(grid[i][j]=='1'){
                    grid[i][j]=0;
                    if(i+1<n&&grid[i+1][j]=='1'){
                        uf.union(i*m+j,(i+1)*m+j);
                    }
                    if(j+1<m&&grid[i][j+1]=='1'){
                        uf.union(i*m+j,i*m+j+1);
                    }
                }
            }
        }
        return uf.getIslandNumber();
    }
    
    class UnionFind{
        UnionFind(char[][] grid){
            int n=grid.length, m=grid[0].length;
            parent=new int[n*m];
            rank=new int[n*m];
            for (int i=0; i<n; i++){
                for (int j=0; j<m; j++){
                    parent[i*m+j]=i*m+j;
                    if(grid[i][j]=='1') count++;
                }
            }            
        }
        int[] parent;
        int[] rank;
        int count;
        
        void union(int p, int q){
            int rootp=find(p);
            int rootq=find(q);
            if(rootp!=rootq){
                if (rank[rootp]<=rank[rootq]){
                    parent[rootp]=rootq;
                    rank[rootq]++;
                } else {
                    parent[rootq]=rootp;
                    rank[rootp]++;
                }
                count--;
            }
        }
        
        int find(int p){
            if(parent[p]!=p) return find(parent[p]);
            return p;
        }
        
        int getIslandNumber(){
            return count;
        }
    }
}
