/*
LeetCode Problem No.461:    https://leetcode.com/problems/hamming-distance/
Author:                     zhangyixing1007
Idea:                       make good use of %, / or >>=1
Time:                       1 ms, beat 96.69%
Space:                      33.4 MB, beat 77.38%
*/

class Solution {
    public int hammingDistance(int x, int y) {
        int ans=0;
        while(x!=0||y!=0){
            ans+=(x%2)^(y%2);
            x>>=1;y>>=1;
        }
        return ans;
    }
}
