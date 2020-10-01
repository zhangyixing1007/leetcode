/*
LeetCode Problem LCP 17:    https://leetcode-cn.com/problems/UlBDOe/
Author:                     zhangyixing1007
Idea:                       dynamic programming, prefix sum formula
Time:                       19 ms, beat 83.90%
Space:                      39.2 MB, beat 96.38%
*/

class Solution {
    public int minimumOperations(String leaves) {
        int g=leaves.charAt(0)=='y'? 1:-1;
        int gmin=g;
        int y=0, n=leaves.length(), ans=n;
        for(int i=1; i<n; i++){
            y=leaves.charAt(i)=='y'? 1:0;
            g+=2*y-1;
            if(i!=n-1) ans=Math.min(ans, gmin-g);
            gmin=Math.min(gmin, g);
        }
        return ans+(g+n)/2;
    }
}
