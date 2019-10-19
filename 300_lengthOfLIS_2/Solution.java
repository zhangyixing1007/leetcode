/*
LeetCode Problem No.300:    https://leetcode.com/problems/longest-increasing-subsequence/
Author:                     zhangyixing1007
Idea:                       dynamic programming + binary search, O(nlogn)
Time:                       1 ms, beat 99.26%
Space:                      35.8 MB, beat 35.10%
*/

class Solution 
{
    public int lengthOfLIS(int[] nums)
    {
        int [] dp = new int[nums.length];
        int len = 0;
        for (int num : nums)
        {
            int i = Arrays.binarySearch(dp,0,len,num);
            if (i < 0) i = -(i+1);
            dp[i] = num;
            if (i == len) len++;
        }
        return len;
    }
}
