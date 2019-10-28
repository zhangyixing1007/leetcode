/*
LeetCode Problem No.739:    https://leetcode.com/problems/daily-temperatures/
Author:                     zhangyixing1007
Idea:                       start from the end, skip smaller items by their answer
Time:                       7 ms, beat 91.82%
Space:                      41.7 MB, beat 95.19%
*/

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        for (int i = T.length-2; i > -1; i--){
            int d = 1;
            if (T[i]<T[i+d]) ans[i]=1;
            else {
                while (i+d < T.length&&T[i]>=T[i+d]&&ans[i+d]!=0){
                    d += ans[i+d];
                }
                if (i+d < T.length)
                    ans[i] = ans[i+d]==0&&T[i]>=T[i+d]? 0:d;
            }
        }
        return ans;
    }
}
