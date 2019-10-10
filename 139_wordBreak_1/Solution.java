/*
LeetCode Problem No.139:    https://leetcode.com/problems/word-break/
Author:                     zhangyixing1007
Idea:                       brutal force, compare with each word in the list (another brutal force is to use a HashSet and compare each substring)
Time:                       overtime
Space:                      unknown
*/

class Solution
{
    public boolean wordBreak(String s, List<String> wordDict)
    {
        this.s = s;
        this.wordDict = wordDict;
        return backtrack(0);    
    }
    
    private String s;
    private List<String> wordDict;
    
    private boolean backtrack(int curr)
    {
        if (curr == s.length()) return true;
        
        for (int i = 0; i < wordDict.size(); i++)
        {
            String tmp = wordDict.get(i);
            int len = tmp.length();
            if (len<=s.length()-curr && tmp.equals(s.substring(curr,curr+len)) && backtrack(curr+len)==true)
                return true;
                
        }
        return false;
    }
}
