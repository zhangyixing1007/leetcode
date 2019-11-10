/*
LeetCode Problem No.042:    https://leetcode.com/problems/trapping-rain-water/
Author:                     zhangyixing1007
Idea:                       scan only once, start from left and right together
Time:                       1 ms, beat 100%
Space:                      37.6 MB, beat 82.74%
*/

class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int leftmax = 0;
        int rightmax = 0;
        int ans = 0;
        while (left < right){
            if (height[left] < height[right]){
                if (height[left]>leftmax)
                    leftmax = height[left++];
                else
                    ans += leftmax - height[left++];
            } else {
                 if (height[right]>rightmax)
                    rightmax = height[right--];
                else
                    ans += rightmax - height[right--];               
            }
        }
        return ans;
    }
}
