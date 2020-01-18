/*
LeetCode Problem No.011:    https://leetcode.com/problems/container-with-most-water/
Author:                     zhangyixing1007
Idea:                       two pointers, move the short one
Time:                       4 ms, beat 75.18%
Space:                      39.7 MB, beat 46.26%
*/

class Solution {
    public int maxArea(int[] height) {
        int l=0, r=height.length-1;
        int max=0;
        while (l<r){
            int curr=Math.min(height[l],height[r])*(r-l);
            max=Math.max(curr,max);
            if (height[l]<height[r]) l++;
            else r--;
        }
        return max;
    }
}
