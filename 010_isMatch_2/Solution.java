/*
LeetCode Problem No.010:    https://leetcode.com/problems/regular-expression-matching/
Author:                     zhangyixing1007
Idea:                       recursion + save intermediate result each time
Time:                       2 ms, beat 99.94%
Space:                      64.92 MB, beat 87.64%
*/

class Solution {
    enum Result{
        TRUE, FALSE
    }
    Result[][] memo;
    
    public boolean isMatch(String s, String p) {
        memo = new Result[s.length()+1][p.length()+1];
        
        return dp(0,0,s,p);
    }    
    
    private boolean dp (int i, int j, String s, String p){
        if (memo[i][j]!=null)
            return memo[i][j] == Result.TRUE;
        if (j == p.length())
            return i == s.length();
        boolean firstMatch = (i!=s.length()) &&
            (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        boolean ans;
        if (p.length() - j >= 2 && p.charAt(j+1) == '*'){
            ans = dp(i,j+2,s,p) || (firstMatch&&dp(i+1,j,s,p));

        } else {
            ans = firstMatch&&dp(i+1,j+1,s,p);
        }
        memo[i][j] = ans == true? Result.TRUE:Result.FALSE;
        return ans;        
    }
}
