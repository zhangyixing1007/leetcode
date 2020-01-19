/*
LeetCode Problem No.62:     https://leetcode.com/problems/unique-paths/
Author:                     zhangyixing1007
Idea:                       simply calculate by formula, use long
Time:                       0 ms, beat 100%
Space:                      32.8 MB, beat 83.92%
*/

class Solution {
    public int uniquePaths(int m, int n) {
        if (m==0||n==0) return 0;
        long result = 1;
        int count = m<n? m-1:n-1;
        int i = 1;
        while (i<=count){
            result *= m + n - 1 - i;
            result /= i;
            i ++;    
        }
        return (int) result;
    }
}
