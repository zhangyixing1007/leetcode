/*
LeetCode Problem No.1434:   https://leetcode-cn.com/problems/number-of-ways-to-wear-different-hats-to-each-other/
Author:                     zhangyixing1007
Idea:                       backtrack, brute force
Time:                       overtime
Space:                      unknown
*/

class Solution {
    public int numberWays(List<List<Integer>> hats) {
        boolean[] visited=new boolean[40];
        back(hats, 0, visited);
        return ans;
    }
    
    int ans=0;
    
    void back(List<List<Integer>> hats, int i, boolean[] visited){
        List<Integer> fav=hats.get(i);
        for(int j=0; j<fav.size(); j++){
            int hat=fav.get(j);
            if(visited[hat]==false){
                if(i!=hats.size()-1){
                    visited[hat]=true;
                    back(hats, i+1, visited);
                    visited[hat]=false;                    
                }else ans++;
            }
        }
    }
}
