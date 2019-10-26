/*
LeetCode Problem No.494:    https://leetcode.com/problems/target-sum/
Author:                     zhangyixing1007
Idea:                       recursion, very simple
Time:                       498 ms, beat 35.72%
Space:                      34.7 MB, beat 84.86%
*/

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return helper(nums, S, 0);    
    }
    
    private int helper(int[] nums, int S, int start){
        if (start == nums.length) 
            return S == 0? 1:0;
        return helper(nums, S + nums[start], start+1) + helper(nums, S - nums[start], start+1);
    }
}
