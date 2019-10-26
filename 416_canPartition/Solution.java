/*
LeetCode Problem No.416:    https://leetcode.com/problems/partition-equal-subset-sum/
Author:                     zhangyixing1007
Idea:                       similar as 494 Version 2
Time:                       4 ms, beat 96.57%
Space:                      35.7 MB, beat 92.15%
*/

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if (sum%2 == 1) return false;
        sum = sum/2;
        int[] dp = new int[sum+1];
        dp[0] = 1;
        for (int num : nums){
            for (int i = sum; i >= num; i--){
                dp[i] += dp[i-num];
            }
            if (dp[sum] != 0 ) return true;
        }
        return nums.length==0;
    }
}
