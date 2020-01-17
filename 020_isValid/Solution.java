/*
LeetCode Problem No.20:    https://leetcode.com/problems/valid-parentheses/
Author:                     zhangyixing1007
Idea:                       push "(" "{" "[" into stack , and while ")" "}" "]", check if top is "(" "{" "[" correspondingly
Time:                       2 ms, beat 97.54%
Space:                      34.1MB, beat 87.48%
*/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            if(c=='('||c=='{'||c=='[')
                stack.push(c);
            else{
                if(stack.isEmpty())
                    return false;
                if(c==')'&&stack.peek()!='(')
                    return false;
                if(c=='}'&&stack.peek()!='{')
                    return false;
                if(c==']'&&stack.peek()!='[')
                    return false;  
                stack.pop();
            }                
        }
        return stack.isEmpty();
    }
}
