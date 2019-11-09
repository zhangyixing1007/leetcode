  
/*
LeetCode Problem No.032:    https://leetcode.com/problems/longest-valid-parentheses/
Author:                     zhangyixing1007
Idea:                       stack
Time:                       9 ms, beat 39.29%
Space:                      37.9 MB, beat 79.91%
*/

class Solution {
    public int longestValidParentheses(String s) {
        int ans = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if (curr == '('){
                stack.push(i);
            } else {
                int start = stack.pop();
                if (stack.isEmpty())
                    stack.push(i);
                else
                    ans = Math.max(ans, i-stack.peek());
            }
        }
        return ans;
    }
}
