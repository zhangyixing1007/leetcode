/*
LeetCode Problem No.139:    https://leetcode.com/problems/word-break/
Author:                     zhangyixing1007
Idea:                       check from the start of the String, "visited" keep the record
Time:                       8 ms, beat 79.40%
Space:                      36.4 MB, beat 80.84%
*/

class Solution
{
    public boolean wordBreak(String s, List<String> wordDict)
    {
        boolean[] visited = new boolean[s.length()+1];
        Set<String> dic = new HashSet(wordDict);
        visited[0] = true;
        for (int i = 0; i <= s.length(); i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (visited[j]==true&&dic.contains(s.substring(j,i)))
                    {visited[i] = true; break;}
            }
        }
        return visited[s.length()];
    }
}
