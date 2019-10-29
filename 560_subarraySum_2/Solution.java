/*
LeetCode Problem No.560:    https://leetcode.com/problems/subarray-sum-equals-k/
Author:                     zhangyixing1007
Idea:                       HashMap, usually used in various sums
Time:                       22 ms, beat 95.92%
Space:                      38.3 MB, beat 93.98%
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum-k);
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
