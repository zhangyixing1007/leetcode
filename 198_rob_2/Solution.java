/*
LeetCode Problem No.198:    https://leetcode.com/problems/house-robber/
Author:                     zhangyixing1007
Idea:                       save and recursion
Time:                       0 ms, beat 100%
Space:                      34.2MB, beat 32.56%
*/

class Solution {
    public int rob(int[] nums) {
        int len=nums.length;
        if(len==0) return 0;
        if(len==1) return nums[0];
        visited=new boolean[len];
        return Math.max(rob(nums,len-1),rob(nums,len-2));
    }
    boolean[] visited;
    int rob(int[] nums,int len){
        if(len==0) return nums[0];
        if(len==1) return Math.max(nums[0],nums[1]);
        if(len==2) return Math.max(nums[0]+nums[2],nums[1]);
        if(!visited[len]) {
            visited[len]=true;
            nums[len]=Math.max(rob(nums,len-2)+nums[len],rob(nums,len-1));
        }
        return nums[len];
    }
}
