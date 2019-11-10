/*
LeetCode Problem No.042:    https://leetcode.com/problems/trapping-rain-water/
Author:                     zhangyixing1007
Idea:                       sum all the min(left_max,right_max) - height
Time:                       1 ms, beat 100%
Space:                      37.6 MB, beat 82.74%
*/

class Solution {
    public int trap(int[] height){
        int len = height.length;
        if (len < 2) return 0;
        int[] lmax = new int[len]; lmax[0] = height[0];
        int[] rmax = new int[len]; rmax[len-1] =height[len-1];
        
        for (int i = 1; i < len; i++){
            lmax[i] = Math.max(lmax[i-1],height[i]);
            rmax[len-i-1] = Math.max(rmax[len-i],height[len-i-1]);
        }
        
        int ans = 0;
        for (int i = 0; i < len; i++){
            ans = ans + Math.min(lmax[i], rmax[i]) - height[i];
        }
        return ans;
    }
}
