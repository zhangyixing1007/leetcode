/*
LeetCode Problem No.983:    https://leetcode-cn.com/problems/minimum-cost-for-tickets/
Author:                     zhangyixing1007
Idea:                       dp
Time:                       1 ms, beat 97.22%
Space:                      38.2 MB, beat 100%
*/

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        this.days=days;
        this.costs=costs;
        memo=new Integer[days.length];
        return dp(0);
    }

    int[] durations=new int[]{1,7,30};
    Integer[] memo;
    int[] days;
    int[] costs;

    int dp(int i){
        if(i>=memo.length) return 0;      
        if(memo[i]!=null) return memo[i];
        memo[i]=Integer.MAX_VALUE;
        for(int k=0; k<3; k++){
            int j=i;
            while(j<days.length&&days[j]<days[i]+durations[k]) j++;
            memo[i]=Math.min(memo[i],costs[k]+dp(j));
        }  
        return memo[i];
    }    
}
