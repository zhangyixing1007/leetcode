/*
LeetCode Problem No.0518:   https://leetcode-cn.com/problems/coin-change-2/
Author:                     zhangyixing1007
Idea:                       dynamic programming
Time:                       4 ms, beat 58.77%
Space:                      35.9 MB, beat 98.78%
*/

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp=new int[amount+1];
        dp[0]=1;
        for(int coin:coins){
            for(int i=0; i<=amount; i++){
                if(i-coin>=0 && dp[i-coin]!=Integer.MAX_VALUE){
                    dp[i]+=dp[i-coin];
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE? -1:dp[amount];
    }
}
