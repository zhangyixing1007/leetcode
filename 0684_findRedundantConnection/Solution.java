/*
LeetCode Problem No.0684:   https://leetcode-cn.com/problems/redundant-connection/
Author:                     zhangyixing1007
Idea:                       unionfind
Time:                       1 ms, beat 95.09%
Space:                      38.9 MB, beat 92.77%
*/

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        this.n=edges.length;
        parent=new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i]=i;        
        }
        for(int[] edge:edges){
            if(isConnected(edge[0], edge[1])){
                return edge;
            }else{
                connect(edge[0], edge[1]);
            }
        }
        return new int[]{};
    }
    int n;
    int[] parent;
    boolean isConnected(int u, int v){
        return root(u)==root(v);
    }
    int root(int p){
        while(p!=parent[p]){
            p=parent[p];
            parent[p]=parent[parent[p]];
        }
        return p;
    }
    void connect(int u, int v){
        int rootu=root(u);
        int rootv=root(v);
        if(rootu>rootv){
            parent[rootv]=rootu;
        }else{
            parent[rootu]=rootv;
        }
    }
}

