/*
LeetCode Problem No.139:    https://leetcode.com/problems/word-break/
Author:                     zhangyixing1007
Idea:                       check from the end of the String, memo keep the record
Time:                       9 ms, beat 74.65%
Space:                      36.8 MB, beat 77.49%
*/

class Solution
{
    public boolean wordBreak(String s, List<String> wordDict)
    {
        return helper(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
    }
    
    private boolean helper(String s, HashSet<String> wordDict, int start, Boolean[] memo)
    {
        if (start == s.length()) return true;
        if (memo[start]!=null) return memo[start];
        
        for (int end = start+1; end <= s.length(); end++)
        {
            if(wordDict.contains(s.substring(start,end))&&helper(s,wordDict,end,memo))
                return memo[start] = true;
        }
        return memo[start] = false;
    }
}
