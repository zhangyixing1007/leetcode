/*
LeetCode Problem No.0834:   https://leetcode-cn.com/problems/sum-of-distances-in-tree/
Author:                     zhangyixing1007
Idea:                       dfs and dynamic programming
Time:                       18 ms, beat 78.38%
Space:                      48.5 MB, beat 5.43%
*/

class Solution {
    int[] dp, size, ans;
    List<Integer>[] next;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        dp=new int[N];
        size=new int[N];
        ans=new int[N];
        next=new List[N];
        for(int i=0; i<N; i++){
            next[i]=new ArrayList<>();
        }
        for(int[] edge:edges){
            next[edge[0]].add(edge[1]);
            next[edge[1]].add(edge[0]);
        }
        size[0]=1;
        dfs(0, -1);
        dfs2(0, -1);
        return ans;
    }
    void dfs(int u, int prev){
        for(int v:next[u]){
            if(v==prev) continue;
            size[v]=1;
            dfs(v, u);
            dp[u]+=dp[v]+size[v];
            size[u]+=size[v];
        }
    }
    void dfs2(int u, int prev){
        ans[u]=dp[u];
        for(int v:next[u]){
            if(v==prev) continue;
            int du=dp[u], dv=dp[v];
            int su=size[u], sv=size[v];
            dp[u]+=-dp[v]-size[v];
            size[u]-=size[v];
            dp[v]+=dp[u]+size[u];
            size[v]+=size[u];
            dfs2(v, u);
            dp[u]=du; dp[v]=dv;
            size[u]=su; size[v]=sv;
        }
    }
}
