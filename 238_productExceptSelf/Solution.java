/*
LeetCode Problem No.238:    https://leetcode.com/problems/product-of-array-except-self/
Author:                     zhangyixing1007
Idea:                       left*right
Time:                       1 ms, beat 100%
Space:                      43.1 MB, beat 96.2%
*/

class Solution 
{
    public int[] productExceptSelf(int[] nums) 
    {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++)
        {
            ans[i] = ans[i-1]*nums[i-1]; 
        }
        for (int i = nums.length-1; i > 0; i--)
        {
            ans[i] *= ans[0];
            ans[0] *= nums[i];
        }
        return ans;
    }
}
