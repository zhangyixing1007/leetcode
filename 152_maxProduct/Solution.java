/*
LeetCode Problem No.152:    https://leetcode.com/problems/maximum-product-subarray/
Author:                     zhangyixing1007
Idea:                       similar to 53, mind negative numbers
Time:                       2 ms, beat 98.47%
Space:                      37 MB, beat 42.42%
*/

class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int max=1;
        int min=1;
        int maxSoFar=Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++){
            if (nums[i]<0){int t=max;max=min;min=t;}
            max=Math.max(max*nums[i],nums[i]);
            min=Math.min(min*nums[i],nums[i]);
            maxSoFar=Math.max(maxSoFar, max);
        }
        return maxSoFar;
    }
}
