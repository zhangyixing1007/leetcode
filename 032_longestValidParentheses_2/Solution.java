/*
LeetCode Problem No.032:    https://leetcode.com/problems/longest-valid-parentheses/
Author:                     zhangyixing1007
Idea:                       brute force, Version 2
Time:                       194 ms, beat 7.10%
Space:                      37.1 MB, beat 84.71%
*/

class Solution {
    public int longestValidParentheses(String s) {
        if (s.length()<2) return 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                int count = 0;
                int start = i;
                boolean flag = true;
                while (i<s.length()){
                    count += s.charAt(i) == '('? 1:-1;
                    i++;
                    if (count == 0){
                        ans = Math.max(ans, i - start);  
                    } else if (count < 0) {
                        flag = false;
                        i--;
                        break;
                    }
                }
                if (flag)
                    i = start;
            }
        }
        return ans;
    }
}
