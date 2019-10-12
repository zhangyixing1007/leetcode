/*
LeetCode Problem No.152:    https://leetcode.com/problems/maximum-product-subarray/
Author:                     zhangyixing1007
Idea:                       similar to 53
Time:                       2 ms, beat 98.47%
Space:                      37 MB, beat 42.42%
*/

class Solution
{
    public int maxProduct(int[] nums)
    {
        int imax = 1;
        int imin = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i]<0)
            {int tmp = imax; imax = imin; imin = tmp;}
            imax = Math.max(imax*nums[i],nums[i]);
            imin = Math.min(imin*nums[i],nums[i]);
            max = Math.max(max,imax);
        }
        return max;
    }
}
