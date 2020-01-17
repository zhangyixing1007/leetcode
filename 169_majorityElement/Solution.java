/*
LeetCode Problem No.169:    https://leetcode.com/problems/majority-element/
Author:                     zhangyixing1007
Idea:                       majority and minority commit suicide in pairs
Time:                       4 ms, beat 70.12%
Space:                      41.9MB, beat 83.65%
*/

class Solution { 
    public int majorityElement(int[] nums) { 
        int count = 0; 
        int candidate = nums[0]; 
        for (int num : nums) { 
            if (count == 0) candidate = num; 
            count += (num == candidate) ? 1 : -1; 
        } 
        return candidate; 
    } 
} 
