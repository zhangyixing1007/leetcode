/*
LeetCode Problem No.121:    https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
Author:                     zhangyixing1007
Idea:                       take difference with so far min, find the max
Time:                       1 ms, beat 99.96%
Space:                      36.7MB, beat 95.21%
*/

class Solution {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE, max=0;
        for(int price:prices){
            min=Math.min(min,price);
            if(price-min>max) max=price-min; 
        }
        return max;
    }
}
