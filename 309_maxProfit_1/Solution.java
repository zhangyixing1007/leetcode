/*
LeetCode Problem No.309:    https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
Author:                     zhangyixing1007
Idea:                       dynamic programming, 4 states 
Time:                       1 ms, beat 100%
Space:                      35.5 MB, beat 82.33%
*/

class Solution {
    public int maxProfit(int[] prices) {
        int hold = Integer.MIN_VALUE;
        int buy = Integer.MIN_VALUE;
        int sold = 0;
        int rest = 0;
        for (int price : prices){
            int pre_sold = sold;
            int pre_buy = buy;
            sold = Math.max(hold,buy) + price;
            buy = rest - price;
            hold = Math.max(hold,pre_buy);
            rest = Math.max(pre_sold,rest);
        }
        return Math.max(sold,rest);            
    }
}
