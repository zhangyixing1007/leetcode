/*
LeetCode Problem No.34:    https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
Author:                    zhangyixing1007
Idea:                      binary search twice
Time:                      0 ms, beat 100%
Space:                     42.8 MB, beat 64.48%
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null||nums.length==0) return new int[]{-1,-1};
        if(nums.length==1) return nums[0]==target? new int[]{0,0}: new int[]{-1,-1};
        int left = findLeft(nums, 0, nums.length-1, target);
        int right = left==-1? -1:findRight(nums, 0, nums.length-1, target);    
        return new int[]{left,right};    
    }
    
    int findLeft(int[] nums, int a, int b, int target){
        if(a==b) return nums[a]==target? a:-1;
        int m=(a+b)/2;
        if (nums[m+1]==target&&nums[m]<nums[m+1]) return m+1;
        if (nums[m]<target) return findLeft(nums, m+1, b, target);
        else return findLeft(nums, a, m, target);
    }

    int findRight(int[] nums, int a, int b, int target){
        if(a==b) return nums[a]==target? a:-1;
        int m=(a+b)/2;
        if (nums[m]==target&&nums[m]<nums[m+1]) return m;
        if (nums[m]>target) return findRight(nums, a, m, target);
        else return findRight(nums, m+1, b, target);
    }    
}
