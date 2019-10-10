/*
LeetCode Problem No.139:    https://leetcode.com/problems/word-break/
Author:                     zhangyixing1007
Idea:                       check for the start of the String, queue keep record of current position
Time:                       10 ms, beat 71.33%
Space:                      36.1 MB, beat 81.68%
*/

class Solution
{
    public boolean wordBreak(String s, List<String> wordDict)
    {
        Set<String> set = new HashSet(wordDict);
        boolean[] visited = new boolean[s.length()];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty())
        {
            int start = q.poll();
            if (visited[start] == false)
            {
                for (int end = start; end <= s.length(); end++)
                {
                    if (set.contains(s.substring(start,end)))
                    {
                        q.add(end);
                        if (end == s.length()) return true;
                    }
                }
                visited[start] = true;
            }
        }
        return false;
    }
}
