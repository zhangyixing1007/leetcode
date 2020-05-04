/*
LeetCode Problem No.045:    https://leetcode.com/problems/jump-game-ii/
Author:                     zhangyixing1007
Idea:                       brute force
Time:                       554 ms, beat 5.01%
Space:                      41.8 MB, beat 5.00%
*/

class Solution {
    public int jump(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int n=nums.length;
        int[] steps=new int[nums.length];
        Arrays.fill(steps,Integer.MAX_VALUE);
        steps[0]=0; 
        for(int i=0; i<n; i++){
            for(int j=1; j<=nums[i]&&i+j<n; j++){
                steps[i+j]=Math.min(steps[i+j],steps[i]+1);
            }            
        }
        return steps[n-1];
    }
}
