/*
LeetCode Problem No.287:    https://leetcode.com/problems/find-the-duplicate-number/
Author:                     zhangyixing1007
Idea:                       in a LinkedList, find the place that the loop starts
Time:                       1 ms, beat 95.50%
Space:                      37.2 MB, beat 95.29%
*/

class Solution
{
    public int findDuplicate(int[] nums)
    {
        if (nums.length==0) return -1;
        int p1 = 0;
        int p2 = 0;
        do
        {
           p1 = nums[nums[p1]];
           p2 = nums[p2];
        }
        while(p1!=p2);
        p1 = 0;
        do
        {
            p1 = nums[p1];
            p2 = nums[p2];
        }
        while(p1!=p2);
        return p1;    
    }
}
