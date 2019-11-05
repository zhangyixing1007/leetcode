/*
LeetCode Problem No.010:    https://leetcode.com/problems/regular-expression-matching/
Author:                     zhangyixing1007
Idea:                       recursion
Time:                       143 ms, beat 26.17%
Space:                      41.2 MB, beat 64.92%
*/

class Solution {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        boolean firstMatch = !s.isEmpty()&&
            (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length()>=2 && p.charAt(1) == '*'){
            return (isMatch(s,p.substring(2))||
                    firstMatch&&isMatch(s.substring(1),p));
        } else {
            return firstMatch&&isMatch(s.substring(1),p.substring(1));
        }
    }
}
