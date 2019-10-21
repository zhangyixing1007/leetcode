/*
LeetCode Problem No.309:    https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
Author:                     zhangyixing1007
Idea:                       dynamic programming, 3 states 
Time:                       1 ms, beat 100%
Space:                      34.6 MB, beat 86.75%
*/

class Solution {
    public int maxProfit(int[] prices) {
        int hold = Integer.MIN_VALUE;
        int sold = 0;
        int rest = 0;
        for (int price : prices){
            int pre = sold;
            sold = hold + price;
            hold = Math.max(hold,rest-price);
            rest = Math.max(pre,rest);
        }
        return Math.max(sold,rest);            
    }
}
