/*
LeetCode Problem No.1024:   https://leetcode-cn.com/problems/video-stitching/
Author:                     zhangyixing1007
Idea:                       sorting + dynamic programming
Time:                       2 ms, beat 22.95%
Space:                      35.7 MB, beat 98.63%
*/

class Solution {
    public int videoStitching(int[][] clips, int T) {
        int[] dp = new int[T + 1];
        Arrays.fill(dp, T+1);
        Arrays.sort(clips, (o1, o2)->o1[0]==o2[0]? o1[1]-o2[1]:o1[0]-o2[0]);
        dp[0] = 0;
        int i=0, prev=-1;
        for(; i<clips.length; i++){
            if(prev==-1 || clips[i][0]!=clips[prev][0]){
                for(int j=clips[i][0]+1; j<=clips[i][1]&&j<=T; j++){

                    dp[j]=Math.min(dp[j], 
                    dp[clips[i][0]]+1);
                }
            }else{
                prev=i; continue;
            }
        }
        return dp[T] == T+1? -1 : dp[T];
    }
}
