/*
LeetCode Problem No.647:    https://leetcode.com/problems/palindromic-substrings/
Author:                     zhangyixing1007
Idea:                       trivial trick in panlindrome, insert '#'
Time:                       3 ms, beat 84.48%
Space:                      34.5 MB, beat 91.44%
*/

class Solution {
    public int countSubstrings(String s) {
        if(s == null || s.length()==0){
            return 0;
        }
        int len = s.length();
        char[] cs = new char[2*len+1];
        Arrays.fill(cs,'#');
        for (int i = 0; i< len; i++){
            cs[2*i+1] = s.charAt(i);
        }
        int ans = len;
        for (int i = 1; i <= cs.length-1; i++){
            int d = 1;
            if (i%2 == 1) d++;
            while (i-d>=0&&i+d<cs.length&&cs[i-d] == cs[i+d]) {
                ans++;
                d+=2;
            }                   
        }
        return ans;
    }
}
