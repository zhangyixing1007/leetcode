/*
LeetCode Problem No.338:    https://leetcode.com/problems/counting-bits
Author:                     zhangyixing1007
Idea:                       iteration, cancel the last "1" on the right
Time:                       1 ms, beat 99.96%
Space:                      38.4 MB, beat 86.52%
*/

class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num+1];    
        for (int i = 1; i < num+1; i++)  {
            ans[i] = ans[i&i-1] + 1;
        }
        return ans;
    }
}
