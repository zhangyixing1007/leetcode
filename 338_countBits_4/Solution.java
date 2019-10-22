/*
LeetCode Problem No.338:    https://leetcode.com/problems/counting-bits
Author:                     zhangyixing1007
Idea:                       iteration, arithmetic shift to the right, faster than i/2 and i%2
Time:                       1 ms, beat 99.96%
Space:                      38.4 MB, beat 86.52%
*/

class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num+1];    
        for (int i = 0; i < num+1; i++)  {
            ans[i] = ans[i>>1] + (i&1);
        }
        return ans;
    }
}
