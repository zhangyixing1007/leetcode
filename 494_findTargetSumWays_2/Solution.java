/*
LeetCode Problem No.494:    https://leetcode.com/problems/target-sum/
Author:                     zhangyixing1007
Idea:                       dynamic programming
Time:                       2 ms, beat 99.88%
Space:                      34.3 MB, beat 85.80%
*/

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if (sum < S || (sum+S)%2 == 1){
            return 0;
        }
        int target = (sum + S)/2;
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int num : nums){
            for (int i= target; i >= num; i--){
                dp[i] += dp[i-num];
            }
        }
        return dp[target];
    }
}
