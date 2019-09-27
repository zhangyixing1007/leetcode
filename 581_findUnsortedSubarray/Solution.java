/*
LeetCode Problem No.581:    https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
Author:                     zhangyixing1007
Idea:                       first find the min and max of unsorted subarray, then find the left and right boundaries 
Time:                       4 ms, beat 94.61%
Space:                      39.3 MB, beat 97.75%
*/

class Solution { 
    public int findUnsortedSubarray(int[] nums) { 
        if (nums.length<2) return 0; 
        boolean flag = false; 
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE; 
        for (int i = 1; i < nums.length; i++) 
        { 
            if (nums[i]<nums[i-1]) flag = true; 
            if (flag) min = Math.min(min,nums[i]); 
        } 
        flag = false; 
        for (int i = nums.length-1; i > 0; i--) 
        { 
            if (nums[i]<nums[i-1]) flag = true; 
            if (flag) max = Math.max(max,nums[i-1]); 
        }     
        if (min==Integer.MAX_VALUE&&max==Integer.MIN_VALUE) return 0; 
        int l = 0; while (nums[l]<=min) l++; 
        int r = nums.length - 1; while (nums[r]>=max) r--; 
        // return Math.max(r-l+1,0); 
        return r-l+1; 
    } 
} 
