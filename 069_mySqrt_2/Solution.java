/*
LeetCode Problem No.069:    https://leetcode-cn.com/problems/sqrtx/
Author:                     zhangyixing1007
Idea:                       Newton method
Time:                       1 ms, beat 100%
Space:                      36.5 MB, beat 5.55%
*/

class Solution {
    public int mySqrt(int x) {
        double C=x, y0=0, y1=x;

        while(Math.abs(y0-y1)>=1e-6){
            y0=y1;
            y1=0.5*(y0+C/y0);
        }
        return (int)y1;
    }
}
