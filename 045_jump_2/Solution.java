/*
LeetCode Problem No.045:    https://leetcode.com/problems/jump-game-ii/
Author:                     zhangyixing1007
Idea:                       greedy algorithm, from left to right
Time:                       400 ms, beat 8.14%
Space:                      42.2 MB, beat 5.00%
*/

class Solution {
    public int jump(int[] nums) {
        if(nums==null||nums.length<2) return 0;
        int n=nums.length;
        int steps=0;
        int lastPos=n-1;
        while(lastPos>0){
            for(int i=0; i<lastPos; i++){
                if(i+nums[i]>=lastPos){
                    lastPos=i; steps++;
                }
            }
        }
        return steps;
    }
}
