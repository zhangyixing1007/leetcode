/*
LeetCode Problem No.050:    https://leetcode-cn.com/problems/powx-n/
Author:                     zhangyixing1007
Idea:                       iteration
Time:                       1 ms, beat 94.50%
Space:                      37 MB, beat 5.88%
*/

class Solution {
    public double myPow(double x, int n) {
        long N=(long) n;
        if(N<0) { x=1/x; N=-N;}
        double ans=1.0, t=x;
        while(N!=0){            
            if(N%2==1){
                ans*=t;
            }
            t=t*t;
            N/=2;
        }
        return ans;
    }
}
