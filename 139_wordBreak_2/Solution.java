/*
LeetCode Problem No.139:    https://leetcode.com/problems/word-break/
Author:                     zhangyixing1007
Idea:                       recursion, keep the record
Time:                       9 ms, beat 74.65%
Space:                      36.8 MB, beat 77.49%
*/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s==null||s.length()==0||wordDict==null||wordDict.size()==0) return false;
        return helper(s, new HashSet(wordDict), 0, new Boolean[s.length()+1]);
    }    
    private boolean helper(String s, HashSet<String> set, int start, Boolean[] record){
        if(start==s.length()) return true;
        if (record[start]!=null) return record[start];
        for (int i=start+1; i<=s.length(); i++){
            if(set.contains(s.substring(start,i))&&helper(s,set,i,record)){
                record[start]=true;
                return true;
            }
        }
        record[start]=false;
        return false;
    }
}
