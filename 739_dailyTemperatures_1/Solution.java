/*
LeetCode Problem No.739:    https://leetcode.com/problems/daily-temperatures/
Author:                     zhangyixing1007
Idea:                       brute force
Time:                       1155 ms, beat 5.01%
Space:                      41.4 MB, beat 95.41%
*/

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        for (int i = 0; i < T.length-1; i++){
            int d = 1;
            while(i+d < T.length && T[i] >= T[i+d]){d++;}
            if ((i+d)<T.length) ans[i] = d;
        }
        return ans;
    }
}
