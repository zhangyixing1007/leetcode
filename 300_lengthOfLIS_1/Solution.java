/*
LeetCode Problem No.300:    https://leetcode.com/problems/longest-increasing-subsequence/
Author:                     zhangyixing1007
Idea:                       dynamic programming, O(n^2)
Time:                       21 ms, beat 61.45%
Space:                      37 MB, beat 17.55%
*/

class Solution
{
    public int lengthOfLIS(int[] nums)
    {
        if (nums.length == 0) return 0;
        int[] ans = new int[nums.length];
        Arrays.fill(ans,1);
        int max = 1;
        for (int i = 1; i < nums.length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (nums[i]>nums[j])                  
                {
                    ans[i] = Math.max(ans[i],ans[j]+1);
                    max = Math.max(max,ans[i]);
                    // System.out.println(Arrays.toString(ans));
                }
            }
        }
        return max;
    }
}
