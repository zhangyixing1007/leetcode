/*
LeetCode Problem No.076:    https://leetcode-cn.com/problems/minimum-window-substring/
Author:                     zhangyixing1007
Idea:                       sliding window
Time:                       5 ms, beat 87.19%
Space:                      39.5 MB, beat 33.33%
*/

class Solution {
    public String minWindow(String s, String t) {
        int[] record=new int[128];
        for(char c:t.toCharArray()){
            record[c]++;
        }
        int L=-1, R=-1, count=0;
        int minLen=s.length()+1;
        int l=0, r=0;
        for(; r<s.length();){
            char c=s.charAt(r);
            record[c]--;
            if(record[c]>=0) count++;
            r++;
            while(count==t.length()){
                if(r-l<minLen){
                    L=l; R=r; minLen=R-L;
                }
                char cc=s.charAt(l);
                record[cc]++;
                if(record[cc]>0) count--;
                l++;
            }
        }
        return minLen==s.length()+1? "":s.substring(L,R);
    }
}
