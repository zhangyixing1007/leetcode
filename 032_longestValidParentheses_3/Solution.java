/*
LeetCode Problem No.032:    https://leetcode.com/problems/longest-valid-parentheses/
Author:                     zhangyixing1007
Idea:                       scan from left and right respectivly
Time:                       2 ms, beat 99.83%
Space:                      36.8 MB, beat 87.26%
*/

class Solution {
    public int longestValidParentheses(String s) {
        int ans = 0, left = 0, right = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i)=='(') left++;
            else right++;
            if (left == right) ans = Math.max(ans, 2*right);
            else if (left < right) {left = 0; right = 0;}
        }
        left = 0; right = 0;
        for (int i = s.length()-1; i > -1; i--){
            if (s.charAt(i)=='(') left++;
            else right++;
            if (left == right) ans = Math.max(ans, 2*right);
            else if (right < left) {left = 0; right = 0;}
        }    
        return ans;
    }
}
