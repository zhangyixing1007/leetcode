/*
LeetCode Problem No.121:    https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
Author:                     zhangyixing1007
Idea:                       similar as Problem 53, maxEndingHere = rices[i]-minSoFar, maxSoFar = maxPriceDiff
Time:                       1 ms, beat 99.96%
Space:                      36.7MB, beat 95.21%, if "return maxPriceDiff", space cost will be higher
*/

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <2) return 0;
        
        int minSoFar = prices[0];
        int maxPriceDiff = 0;
        
        for (int i = 1; i<prices.length; i++)
        {
            if (minSoFar>prices[i]) minSoFar = prices[i];
            if (prices[i]-minSoFar>maxPriceDiff) maxPriceDiff = prices[i]-minSoFar;
        }
        if (maxPriceDiff>0) return maxPriceDiff;
        else return 0;
    }
}
