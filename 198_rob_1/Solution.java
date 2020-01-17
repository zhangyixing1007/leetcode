/*
LeetCode Problem No.198:    https://leetcode.com/problems/house-robber/
Author:                     zhangyixing1007
Idea:                       interesting loop
Time:                       0 ms, beat 100%
Space:                      34.1MB, beat 47.64%
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
