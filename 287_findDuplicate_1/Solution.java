/*
LeetCode Problem No.287:    https://leetcode.com/problems/find-the-duplicate-number/
Author:                     zhangyixing1007
Idea:                       brute force
Time:                       62 ms, beat 9.46%
Space:                      37.2 MB, beat 95.29%
*/

class Solution
{
    public int findDuplicate(int[] nums)
    {
        if (nums.length==0) return -1;
        for (int i = 1; i < nums.length; i++)
        {
            for (int j = 0; j < i; j++)
            {if (nums[i]==nums[j]) return nums[i];}
        }        
        return -1;
    }
}
