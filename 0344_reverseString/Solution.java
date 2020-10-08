/*
LeetCode Problem No.0344:   https://leetcode-cn.com/problems/reverse-string/
Author:                     zhangyixing1007
Idea:                       one loop
Time:                       1 ms, beat 99.98%
Space:                      45.2 MB, beat 90.35%
*/

class Solution {
    public void reverseString(char[] s) {
        for(int i=0; i<s.length/2; i++){
            char c=s[i];
            s[i]=s[s.length-1-i];
            s[s.length-1-i]=c;
        }
    }
}
