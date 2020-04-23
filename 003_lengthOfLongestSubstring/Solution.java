/*
LeetCode Problem No.003:    https://leetcode.com/problems/longest-substring-without-repeating-characters/
Author:                     zhangyixing1007
Idea:                       int[] as record
Time:                       4 ms, beat 91.50%
Space:                      36.3 MB, beat 88.16%
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0) return 0;
        int[] prev=new int[128];
        Arrays.fill(prev,-1);
        char[] cs=s.toCharArray();
        int maxLen=0, len=0;
        for(int i=0; i<cs.length; i++){
            char c=cs[i];
            if(prev[c]==-1){
                len++;
            }else{
                len=Math.min(len+1, i-prev[c]);
            }
            maxLen=Math.max(maxLen,len);
            prev[c]=i;
        }
        return maxLen;
    }
}
