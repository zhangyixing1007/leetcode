/*
LeetCode Problem No.084:    https://leetcode.com/problems/largest-rectangle-in-histogram
Author:                     zhangyixing1007
Idea:                       mono stack
Time:                       13 ms, beat 82.06%
Space:                      40.6 MB, beat 37.91%
*/

class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack=new ArrayDeque<>();
        stack.push(-1);
        int maxArea=0;
        for(int i=0; i<heights.length; i++){
            while(stack.peek()!=-1
                  &&heights[stack.peek()]>=heights[i]){
                maxArea=Math.max(maxArea, heights[stack.pop()]*(i-stack.peek()-1));
            }
            stack.push(i);
        }
        while(stack.peek()!=-1){
            maxArea=Math.max(maxArea, heights[stack.pop()]*(heights.length-stack.peek()-1));
        }
        return maxArea;
    }
}
