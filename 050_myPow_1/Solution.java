/*
LeetCode Problem No.050:    https://leetcode-cn.com/problems/powx-n/
Author:                     zhangyixing1007
Idea:                       recursion
Time:                       1 ms, beat 94.50%
Space:                      37 MB, beat 5.88%
*/

class Solution {
    public double myPow(double x, int n) {
        long N=(long) n;
        return N>=0? cal(x,N):1.0/cal(x,-N);
    }

    double cal(double x, long n){
        if(n==0) return 1.0;
        double t=cal(x, n/2);
        t*=t;
        if(n%2==1) t*=x;
        return t;
    }
}
