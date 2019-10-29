/*
LeetCode Problem No.739:    https://leetcode.com/problems/daily-temperatures/
Author:                     zhangyixing1007
Idea:                       start from the end, skip smaller items by their answer, faster than Version 2
Time:                       5 ms, beat 98.27%
Space:                      42.5 MB, beat 94.09%
*/

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        for (int i = T.length-2; i > -1; i--){
            int j = 0;
            for (j = i+1; j<T.length; j += ans[j]){
                if (T[i] < T[j]) {
                    ans[i] = j-i; break;
                }
                if (ans[j] == 0) break;
            }
        }
        return ans;
    }
}
