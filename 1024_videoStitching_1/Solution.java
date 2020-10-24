/*
LeetCode Problem No.1024:   https://leetcode-cn.com/problems/video-stitching/
Author:                     zhangyixing1007
Idea:                       dynamic programming
Time:                       2 ms, beat 22.95%
Space:                      35.8 MB, beat 98.36%
*/

class Solution {
    public int videoStitching(int[][] clips, int T) {
        int[] dp = new int[T + 1];
        Arrays.fill(dp, T+1);
        dp[0] = 0;
        for (int i = 1; i <= T; i++) {
            for (int[] clip : clips) {
                if (clip[0] < i && i <= clip[1]) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[T] == T+1? -1 : dp[T];
    }
}
