/*
LeetCode Problem No.62:     https://leetcode.com/problems/unique-paths/
Author:                     zhangyixing1007
Idea:                       recursion
Time:                       overtime
Space:                      unknown
*/

class Solution {
    public int uniquePaths(int m, int n) {
        if(m<=1||n<=1) return 1;
        return combination(m-1,m+n-2);
    }
    int combination(int n, int m){
        if(m==0) return 0;
        if(n==0) return 1;
        if(n==1) return m;
        return combination(n-1, m-1)+combination(n, m-1);
    }
}
