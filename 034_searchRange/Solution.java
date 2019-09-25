/*
LeetCode Problem No.34:    https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
Author:                    zhangyixing1007
Idea:                      search target by binary search, and find the left and right boundary sequentially
Time:                      0 ms, beat 100%
Space:                     42.4 MB, beat 72.43%
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n==0) return (new int[]{-1,-1});
        if (n==1) return nums[0]==target? new int[]{0,0}:new int[]{-1,-1};
        
        int left = 0, right = n-1;
        
        while (left<=right)
        {
            if(target<nums[left]||target>nums[right]) 
                return (new int[]{-1,-1});
            int medium = (left+right)/2;
            if (nums[medium]==target) {left = medium; break;}
            else if (nums[medium]<target) left = medium+1;
            else right = medium-1;
        }
        if (nums[left]!=target) {left = -1; right = -1;}
        else {right = left;}
        
        if (left == -1) return (new int[]{-1,-1});
            
        while (right+1<n && nums[right+1]==nums[right]) right++;
        while (left-1>-1 && nums[left-1]==nums[left]) left--;
        return (new int[]{left,right});
    }
    
}
