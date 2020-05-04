/*
LeetCode Problem No.045:    https://leetcode.com/problems/jump-game-ii/
Author:                     zhangyixing1007
Idea:                       greedy algorithm, from right to left
Time:                       2 ms, beat 94.93%
Space:                      41.7 MB, beat 5.00%
*/

class Solution {
    public int jump(int[] nums) {
        if(nums==null||nums.length<2) return 0;
        int n=nums.length;
        int steps=0;
        int maxPos=0;
        int end=0;
        for(int i=0; i<n-1; i++){
            maxPos=Math.max(maxPos,i+nums[i]);
            if(i==end){
                end=maxPos;
                steps++;
            }
        }
        return steps;
    }
}
