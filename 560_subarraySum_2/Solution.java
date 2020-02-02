/*
LeetCode Problem No.560:    https://leetcode.com/problems/subarray-sum-equals-k/
Author:                     zhangyixing1007
Idea:                       HashMap, usually used in various sums
Time:                       22 ms, beat 95.92%
Space:                      38.3 MB, beat 93.98%
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map=new HashMap<>();
        map.put(0,1);
        int ans=0, sum=0;
        for (int num:nums){
            sum+=num;
            ans+=map.getOrDefault(sum-k,0);
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}
