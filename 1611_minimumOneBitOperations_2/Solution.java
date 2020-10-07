/*
LeetCode Problem No.1611:   https://leetcode-cn.com/problems/minimum-one-bit-operations-to-make-integers-zero/
Author:                     zhangyixing1007
Idea:                       math formula
Time:                       0 ms, beat 100%
Space:                      35.6 MB, beat 81.18%
*/

class Solution {
    public int minimumOneBitOperations(int n) {
        int res=0;
        while(n!=0){
            res^=n;
            n>>=1;
        }
        return res;
    }
}
