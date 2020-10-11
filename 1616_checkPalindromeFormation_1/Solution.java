/*
LeetCode Problem No.1616:   https://leetcode-cn.com/problems/split-two-strings-to-make-palindrome/
Author:                     zhangyixing1007
Idea:                       recursion
Time:                       24 ms
Space:                      52.4 MB
*/

class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        int n=a.length();
        return check1(a, b, 0, n-1) || check2(a, b, 0, n-1);
    }
    boolean check1(String a, String b, int start, int end){
        if(start>=end) return true;
        if(check(a, start, end) || check(b, start, end)) return true;
        if(a.charAt(start)==b.charAt(end) && check1(a, b, start+1, end-1))
            return true;
        return false;
    }
    boolean check2(String a, String b, int start, int end){
        if(start>=end) return true;
        if(check(a, start, end) || check(b, start, end)) return true;
        if(b.charAt(start)==a.charAt(end) && check2(a, b, start+1, end-1))
            return true;
        return false;
    }
    boolean check(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start)==s.charAt(end)){
                start++; end--;
            }else{
                return false;
            }
        }
        return true;
    }
}
