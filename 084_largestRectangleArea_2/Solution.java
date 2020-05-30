/*
LeetCode Problem No.084:    https://leetcode.com/problems/largest-rectangle-in-histogram
Author:                     zhangyixing1007
Idea:                       divide and conquer
Time:                       254 ms, beat 43.65%
Space:                      42.3 MB, beat 54.71%
*/ 

class Solution {
    int maxArea = 0;
    public int largestRectangleArea(int[] heights) {
        subProblem(heights,0,heights.length-1);
        return maxArea;
    }
    
    void subProblem(int[] heights, int left, int right){
        if (left==right){
            maxArea = Math.max(maxArea,heights[left]);
        } else if (left < right) {
            int min = Integer.MAX_VALUE;
            int id = -1;
            for (int i = left; i < right+1; i++){
                if (min>heights[i]){
                    min = heights[i]; id = i;
                }
            }
            maxArea = Math.max(maxArea, (right-left+1)*min);
            subProblem(heights, left, id-1);
            subProblem(heights, id+1, right);
        }
    }
}
