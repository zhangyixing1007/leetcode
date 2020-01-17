/*
LeetCode Problem No.70:     https://leetcode.com/problems/climbing-stairs/
Author:                     zhangyixing1007
Idea:                       iteration, save only two values
Time:                       0 ms, beat 100%
Space:                      32.8MB, beat 74.43%
*/

class Solution {
    public int climbStairs(int n) {
        if(n==1||n==2) return n;
        int first=1, second=2;
        while(n!=2){
            int tmp=second;
            second=first+second;
            first=tmp;
            n--;
        }
        return second;
    }
}
