/*
LeetCode Problem No.1024:   https://leetcode-cn.com/problems/video-stitching/
Author:                     zhangyixing1007
Idea:                       greedy algorithm
Time:                       0 ms, beat 100%
Space:                      36.1 MB, beat 87.71%
*/

class Solution {
    public int videoStitching(int[][] clips, int T) {
        int[] max=new int[T+1];
        for(int[] clip:clips){
            if(clip[0]>T) continue;
            max[clip[0]]=Math.max(max[clip[0]], clip[1]);
        }
        int prev=0, last=0, ans=0;
        for(int i=0; i<T; i++){
            last=Math.max(last, max[i]);
            if(last==i) return -1;
            if(prev==i){
                ans++;
                prev=last;
            }
        }
        return ans;
    }
}
