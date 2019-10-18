/*
LeetCode Problem No.279:    https://leetcode.com/problems/perfect-squares/
Author:                     zhangyixing1007
Idea:                       dynamic programming
Time:                       35 ms, beat 84.33%
Space:                      35.4 MB, beat 41.69%
*/

class Solution
{
    public int numSquares(int n)
    {
        int[] ans = new int[n+1];
        for (int i = 1; i<n+1; i++)
        {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= Math.sqrt(i); j++)
            {
                min = Math.min(min,ans[i-j*j]+1);
            }
            ans[i]=min;
        }
        return ans[n];
    }
}
