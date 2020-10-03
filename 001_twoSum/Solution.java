/*
LeetCode Problem No.1:      https://leetcode.com/problems/two-sum/
Author:                     zhangyixing1007
Idea:                       save previous value in HashMap
Time:                       2 ms, beat 99.58%
Space:                      39.1MB, beat 42.80%
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
