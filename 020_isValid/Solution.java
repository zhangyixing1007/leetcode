/*
LeetCode Problem No.20:    https://leetcode.com/problems/valid-parentheses/
Author:                     zhangyixing1007
Idea:                       push "(" "{" "[" into stack , and while ")" "}" "]", check if top is "(" "{" "[" correspondingly
Time:                       2 ms, beat 97.54%
Space:                      34.1MB, beat 87.48%
*/

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> bracket = new Stack<Character>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '('|| c == '{' || c == '[')
            {bracket.push(c);}
            else{
                if (bracket.empty()==true) return false;
                char t = bracket.pop();
                if (c == ')'&& t!='(')
                {return false;}
                else if (c == ']'&& t!='[')
                {return false;}
                else if (c == '}'&& t!='{')
                {return false;}                 
            }       
        }
        if(bracket.empty()==true) return true;
        else return false;
    }
}
