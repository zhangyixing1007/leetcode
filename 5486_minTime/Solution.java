/*
LeetCode Problem No.5406:   https://leetcode-cn.com/problems/minimum-time-to-collect-all-apples-in-a-tree/
Author:                     zhangyixing1007
Idea:                       loop from larger nodes to smaller nodes
Time:                       3 ms, beat 100%
Space:                      74.1 MB, beat 100%
*/

class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        int[] back=new int[n];
        int ans=0;
        for(int i=0; i<edges.length; i++){
            back[edges[i][1]]=edges[i][0];
        }
        for(int i=hasApple.size()-1; i>0; i--){
            if(hasApple.get(i)) {
                ans++;
                hasApple.set(back[i],true);
            }
        }
        return ans*2;
    }
}
