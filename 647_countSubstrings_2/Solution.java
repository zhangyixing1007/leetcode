/*
LeetCode Problem No.647:    https://leetcode.com/problems/palindromic-substrings/
Author:                     zhangyixing1007
Idea:                       use private function to avoid if-else discussion
Time:                       2 ms, beat 94.79%
Space:                      34.4 MB, beat 92.34%
*/

class Solution{
    public int countSubstrings(String s) {
        int count = 0;
        int i;
        for(i = 0; i < s.length(); i++){
            count += countPalindrome(s, i, i);
            count += countPalindrome(s, i, i + 1);
        }
         return count;
    }
    public int countPalindrome (String s, int left, int right){
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)){
            count++;
        }
        return count;
    }
}
