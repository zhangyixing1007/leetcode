/*
LeetCode Problem No.032:    https://leetcode.com/problems/longest-valid-parentheses/
Author:                     zhangyixing1007
Idea:                       scan from left and right respectivly
Time:                       2 ms, beat 99.83%
Space:                      37.6 MB, beat 81.71%
*/

class Solution {
    public int longestValidParentheses(String s) {
        if (s.length() < 2) 
            return 0;
        int ans = 0;
        int[] dp = new int[s.length()+1];
        for (int i = 2; i < dp.length; i++){
            if (s.charAt(i-1) == ')'){
                if (s.charAt(i-2) == '('){
                    dp[i] = dp[i-2] + 2;
                } else if (i-1-dp[i-1] > 0 && s.charAt(i-2-dp[i-1]) == '('){
                    dp[i] = dp[i-1] + dp[i-2-dp[i-1]]+2;
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }
}
