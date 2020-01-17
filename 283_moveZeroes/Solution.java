/*
LeetCode Problem No.283:    https://leetcode.com/problems/move-zeroes/
Author:                     zhangyixing1007
Idea:                       exchange nums[i] with the first zero 
Time:                       0 ms, beat 100%
Space:                      37.3MB, beat 95.82%
*/

class Solution { 
    public void moveZeroes(int[] nums) { 
        for (int i = 0, j = 0; i < nums.length; i++) { 
            if(nums[i]!=0) { 
                if(i!=j) 
                {int tmp = nums[i];nums[i] = nums[j];nums[j] = tmp;}                
                j++; 
            } 
        } 
    } 
} 
