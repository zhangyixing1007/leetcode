/*
LeetCode Problem No.338:    https://leetcode.com/problems/counting-bits
Author:                     zhangyixing1007
Idea:                       iteration, /, %
Time:                       2 ms, beat 94.32%
Space:                      38.8 MB, beat 86.33%
*/

class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num+1];    
        for (int i = 0; i < num+1; i++)  {
            ans[i] = ans[i/2] + i%2;
        }
        return ans;
    }
}
