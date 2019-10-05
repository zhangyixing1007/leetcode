/*
LeetCode Problem No.1:      https://leetcode.com/problems/two-sum/
Author:                     zhangyixing1007
Idea:                       loop once save values in HashMap, and check its complement
Time:                       3 ms, beat 99.12%
Space:                      37.8MB, beat 82.40%
*/

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
    Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i ++){
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i){
                return new int[] {map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}
