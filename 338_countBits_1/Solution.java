/*
LeetCode Problem No.338:    https://leetcode.com/problems/counting-bits
Author:                     zhangyixing1007
Idea:                       iteration, dynamic programming
Time:                       2 ms, beat 94.45%
Space:                      38.1 MB, beat 86.52%
*/

class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num+1];
        int power = 1;
        for (int i = 1; i < ans.length; i++){
            if (i==power){
                ans[i] = 1; power*=2;
            }
            else{
                ans[i] = ans[i-power/2]+1;
            }
        }
        return ans;
    }
}
