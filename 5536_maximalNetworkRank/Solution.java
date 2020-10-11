/*
LeetCode Problem No.5536:   https://leetcode-cn.com/problems/maximal-network-rank/
Author:                     zhangyixing1007
Idea:                       A+B(-1)
Time:                       39 ms
Space:                      39.4 MB
*/

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        List<Integer>[] list=new ArrayList[n];
        for(int i=0; i<n; i++){
            list[i]=new ArrayList<>();
        }
        for(int[] road:roads){
            list[road[0]].add(road[1]);
            list[road[1]].add(road[0]);
        }
        int ans=0, curr=0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                curr=list[i].size()+list[j].size();
                if(list[i].contains(j)) curr--;
                ans=Math.max(ans, curr);
            }
        }
        return ans;
    }
}
