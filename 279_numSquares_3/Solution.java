/*
LeetCode Problem No.279:    https://leetcode.com/problems/perfect-squares/
Author:                     zhangyixing1007
Idea:                       (brute force) dynamic programming, basis of Version 1
Time:                       47 ms, beat 34.17%
Space:                      35.5 MB, beat 50.18%
*/

class Solution {
    public int numSquares(int n) {
        if (n==0||n==1) return n;
        int[] record=new int[n+1];
        for (int i=1; i*i<=n; i++){
            record[i*i]=1;
        }
        for (int i=2; i<n+1; i++){
            for (int j=1; j<i; j++){
                if(record[j]!=0&&record[i-j]!=0){
                    int t=record[j]+record[i-j];
                    record[i]=record[i]==0? t:Math.min(record[i],t);
                }                    
            }
        }
        return record[n];
    }
}
