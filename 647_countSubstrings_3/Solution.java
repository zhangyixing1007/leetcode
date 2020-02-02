/*
LeetCode Problem No.647:    https://leetcode.com/problems/palindromic-substrings/
Author:                     zhangyixing1007
Idea:                       subfunction for separate cases+recursion
Time:                       3 ms, beat 84.48%
Space:                      34.6 MB, beat 53.46%
*/

class Solution {
    public int countSubstrings(String s) {
        char[] ch=s.toCharArray();
        int sum=0;
        for(int i=0; i<ch.length; i++){
            sum+=isPalindrome(ch, i, i);
            sum+=isPalindrome(ch, i, i+1);
        }
        return sum;
    }
    
    int isPalindrome(char[] ch, int l, int r){
        if(l<0||r>=ch.length) return 0;
        if(ch[l]==ch[r]) return 1+isPalindrome(ch, l-1, r+1);
        return 0;
    }
}
