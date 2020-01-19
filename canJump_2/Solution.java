/*
LeetCode Problem No.55:     https://leetcode.com/problems/jump-game/
Author:                     zhangyixing1007
Idea:                       simplist idea, loop from the end
Time:                       1334 ms, beat 5.02%
Space:                      39.2 MB, beat 58.34%
*/

class Solution {
    public boolean canJump(int[] nums) { 
        if(nums==null||nums.length==0) return true;
        for(int i=nums.length-2; i>-1; i--){
            for(int j=1; i+j<nums.length-1&&j<=nums[i]; j++){
                nums[i]=Math.max(nums[i], nums[i+j]+j);
            }
        }            
        return nums[0]>=nums.length-1;    
    }
}
