/*
LeetCode Problem No.983:    https://leetcode-cn.com/problems/minimum-cost-for-tickets/
Author:                     zhangyixing1007
Idea:                       backtrack, brute force
Time:                       timeout
Space:                      unknown
*/

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        this.days=days;
        this.costs=costs;
        return backtrack(0,-1,0);
    }

    int[] days;
    int[] costs;

    int backtrack(int index, int lastDay, int money){
        if(index==days.length) return money;
        if(days[index]<=lastDay){
            return backtrack(index+1,lastDay,money);       
        }
        if(days[days.length-1]<=lastDay) return money;
        //3 choices, we go through them
        int cost0=backtrack(index,days[index],money+costs[0]);
        int cost1=backtrack(index,days[index]+6,money+costs[1]);
        int cost2=backtrack(index,days[index]+29,money+costs[2]);
        return Math.min(Math.min(cost0,cost1),cost2);
    }
}
