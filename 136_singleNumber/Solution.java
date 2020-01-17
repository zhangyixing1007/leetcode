/*
LeetCode Problem No.136:    https://leetcode.com/problems/single-number/
Author:                     zhangyixing1007
Idea:                       property of XOR, a XOR a = 0, a XOR 0 = a
Time:                       1 ms, beat 99.87%
Space:                      38 MB, beat 97.47%
*/

class Solution {
    public int singleNumber(int[] nums) {
        for (int i=1; i<nums.length; i++){
            nums[0]^=nums[i];
        }
        return nums[0];
    }
}
