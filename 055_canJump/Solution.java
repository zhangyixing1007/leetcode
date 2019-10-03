/*
LeetCode Problem No.55:     https://leetcode.com/problems/jump-game/
Author:                     zhangyixing1007
Idea:                       only one loop, start from the end of the array
Time:                       1 ms, beat 100%
Space:                      40.7MB, beat 82.63%
*/

class Solution {
    public boolean canJump(int[] nums) {
        int reachable = nums.length==0? 0:nums.length-1;
        for (int i = nums.length-1; i >= 0; i--)
        {
            if (nums[i]+i>=reachable) reachable = i;
        }
        return (reachable==0? true:false);
    }
}
