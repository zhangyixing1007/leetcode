/*
LeetCode Problem No.003:    https://leetcode.com/problems/longest-substring-without-repeating-characters/
Author:                     zhangyixing1007
Idea:                       int[] as record
Time:                       4 ms, beat 91.50%
Space:                      36.3 MB, beat 88.16%
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] record=new int[128];
        Arrays.fill(record,-1);
        int len=0, maxLen=0;
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            if(record[c]==-1){
                record[c]=i; len++; maxLen=Math.max(len,maxLen);
            } else {
                len=Math.min(len+1,i-record[c]); maxLen=Math.max(len,maxLen);
                record[c]=i;
            }
        }
        return maxLen;
    }
}
