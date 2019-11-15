/*
LeetCode Problem No.084:    https://leetcode.com/problems/largest-rectangle-in-histogram
Author:                     zhangyixing1007
Idea:                       iteration, still slow but faster than easiest recursion
Time:                       705 ms, beat 14.92%
Space:                      40.7 MB, beat 90.88%
*/

class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++){
            int left = i, right = i;
            while (left-1>=0 && heights[left-1]>=heights[i]) left--;
            while (right+1<heights.length && heights[right+1]>=heights[i]) right++;
            int area = (right-left+1)*heights[i];
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }
}
