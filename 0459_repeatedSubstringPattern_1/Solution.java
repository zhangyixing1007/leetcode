/*
LeetCode Problem No.0459:   https://leetcode-cn.com/problems/repeated-substring-pattern/
Author:                     zhangyixing1007
Idea:                       indexOf
Time:                       95 ms, beat 49.16%
Space:                      39.2 MB, beat 66.47%
*/

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String t=s+s;
        return t.indexOf(s, 1)<s.length();
    }
}
