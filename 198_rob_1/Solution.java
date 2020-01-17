/*
LeetCode Problem No.198:    https://leetcode.com/problems/house-robber/
Author:                     zhangyixing1007
Idea:                       simple recursion, no saving
Time:                       4 ms, beat 70.21%
Space:                      41.9MB, beat 83.65%
*/

class Solution { 
    public int rob(int[] nums) { 
        int first = 0; 
        int second = 0; 
        for (int num:nums) { 
            int tmp = second; 
            second = Math.max(first+num,second); 
            first = tmp; 
        } 
        return second; 
    } 
} 
