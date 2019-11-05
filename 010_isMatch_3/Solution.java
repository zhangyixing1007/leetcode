/*
LeetCode Problem No.010:    https://leetcode.com/problems/regular-expression-matching/
Author:                     zhangyixing1007
Idea:                       recursion + save intermediate result each time
Time:                       2 ms, beat 99.94%
Space:                      36.6 MB, beat 86.35%
*/

class Solution {
    Boolean[][] memo;
    
    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length()+1][p.length()+1];        
        return dp(0,0,s,p);
    }
    
    
    private Boolean dp (int i, int j, String s, String p){
        if (memo[i][j]!=null)
            return memo[i][j] == true;
        if (j == p.length())
            return i == s.length();
        boolean firstMatch = (i!=s.length()) &&
            (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if (p.length() - j >= 2 && p.charAt(j+1) == '*'){
            memo[i][j] = dp(i,j+2,s,p) || (firstMatch&&dp(i+1,j,s,p));


        } else {
            memo[i][j] = firstMatch&&dp(i+1,j+1,s,p);
        }
        return memo[i][j];        
    }
}
