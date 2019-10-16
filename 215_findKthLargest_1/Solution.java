/*
LeetCode Problem No.215:    https://leetcode.com/problems/kth-largest-element-in-an-array/
Author:                     zhangyixing1007
Idea:                       Array.sort + return 
Time:                       4 ms, beat 89.98%
Space:                      95.89 MB, beat 94.67%
*/

class Solution
{
    public int findKthLargest(int[] nums, int k)
    {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
