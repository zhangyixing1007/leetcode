/*
LeetCode Problem No.279:    https://leetcode.com/problems/perfect-squares/
Author:                     zhangyixing1007
Idea:                       dynamic programming
Time:                       35 ms, beat 84.33%
Space:                      35.4 MB, beat 41.69%
*/

class Solution {
    public int numSquares(int n) {
        if (n==0||n==1) return n;
        int[] record=new int[n+1];
        for (int i=1; i<n+1; i++){
            record[i]=Integer.MAX_VALUE;
            for (int j=1; j*j<=i; j++){
                    int t=record[i-j*j]+1;
                    record[i]=Math.min(record[i],t);                  
            }
        }
        return record[n];
    }
}
