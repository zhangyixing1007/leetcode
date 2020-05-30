/*
LeetCode Problem No.454:    https://leetcode-cn.com/problems/4sum-ii/
Author:                     zhangyixing1007
Idea:                       HashMap
Time:                       78 ms, beat 81.65%
Space:                      58.3 MB, beat 25%
*/

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map=new HashMap<>();
        int ans=0;
        for(int a:A){
            for(int b:B){
                map.put(a+b, map.getOrDefault(a+b, 0)+1);
            }
        }
        for(int c:C){
            for(int d:D){
                ans+=map.getOrDefault(-c-d, 0);
            }
        }
        return ans;
    }
}
