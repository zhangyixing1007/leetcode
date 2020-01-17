/*
LeetCode Problem No.448:    https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
Author:                     zhangyixing1007
Idea:                       put nums[i] to where it should be and then count
Time:                       7 ms, beat 98.42%
Space:                      47.3MB, beat 95.66%
*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i=0; i<nums.length; i++){
            int change=nums[i];
            while (change!=nums[change-1]) {
                int tmp=nums[change-1];nums[change-1]=change;change=tmp;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<nums.length; i++){
            if (nums[i]!=i+1) list.add(i+1);
        }
        return list;
    }
}
