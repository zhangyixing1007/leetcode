/*
LeetCode Problem No.70:     https://leetcode.com/problems/climbing-stairs/
Author:                     zhangyixing1007
Idea:                       iteration, save result in array 
Time:                       0 ms, beat 100%
Space:                      32.8MB, beat 74.43%
*/


class Solution {
    public int climbStairs(int n) {
        if (n<4) return n;
        
        int[] methods = new int[n+1];
        methods[1] = 1;
        methods[2] = 2;
        for (int i = 3; i<methods.length; i++)
        {methods[i] = methods[i-1] + methods[i-2];}
        return methods[n];        
    }
}
