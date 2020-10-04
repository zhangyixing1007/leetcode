/*
LeetCode Problem No.5515:   https://leetcode-cn.com/problems/special-array-with-x-elements-greater-than-or-equal-x/
Author:                     zhangyixing1007
Idea:                       sort
Time:                       1 ms
Space:                      36.7 MB
*/

class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        if(nums[nums.length-1]<0) return 0;
        else if(nums[0]>=nums.length) return nums.length;
        for(int i=1; i<nums.length; i++){
            if(nums[nums.length-1-i]<i&&nums[nums.length-i]>=i)
                return i;
        }
        return -1;
    }
}
