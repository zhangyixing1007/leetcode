/*
LeetCode Problem No.139:    https://leetcode.com/problems/word-break/
Author:                     zhangyixing1007
Idea:                       iteration, keep the record
Time:                       8 ms, beat 79.40%
Space:                      36.4 MB, beat 80.84%
*/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s==null||s.length()==0||wordDict==null||wordDict.size()==0) 
            return false;
        boolean[] visited=new boolean[s.length()+1];
        HashSet<String> set= new HashSet<>(wordDict);
        visited[0]=true;
        for (int i=0; i<s.length(); i++){
            if (visited[i]){
                for (int j=i+1; j<s.length()+1; j++){
                    if(set.contains(s.substring(i,j)))
                        visited[j]=true;
                }            
            }
        }
        return visited[visited.length-1];
    }
}
