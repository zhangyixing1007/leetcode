/*
LeetCode Problem LCP 17:    https://leetcode-cn.com/problems/UlBDOe/
Author:                     zhangyixing1007
Idea:                       dynamic programming, 3 states
Time:                       19 ms, beat 83.90%
Space:                      39.3 MB, beat 94.76%
*/

class Solution {
    public int minimumOperations(String leaves) {
        int state0=leaves.charAt(0)=='y'? 1:0;
        int state1=leaves.length();
        int state2=leaves.length();
        for(int i=1; i<leaves.length(); i++){
            int y=leaves.charAt(i)=='y'? 1:0;
            state2=Math.min(state1,state2)+y;
            state1=Math.min(state0,state1)+1-y;
            state0=state0+y;
        }
        return state2;
    }
}
