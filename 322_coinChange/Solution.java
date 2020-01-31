/*
LeetCode Problem No.322:    https://leetcode.com/problems/coin-change
Author:                     zhangyixing1007
Idea:                       dynamic programming, similar to 279
Time:                       14 ms, beat 90.05%
Space:                      35.8 MB, beat 95.25%
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount <= 0) return 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        for (int i = 1; i < dp.length; i++){
            for (int j = 0; j < coins.length; j++){
                int coin = coins[j];
                if (i==coin) dp[i] = 1;
                if (i>coin)
                    dp[i] = Math.min(dp[i],dp[i - coin]+1);     
            }
        }
        return dp[amount]==amount+1? -1:dp[amount];
    }
}
