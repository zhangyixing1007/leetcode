/*
LeetCode Problem No.1365:   https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
Author:                     zhangyixing1007
Idea:                       prefix sum
Time:                       1 ms, beat 100.00%
Space:                      38.1 MB, beat 99.48%
*/

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count=new int[101];
        for(int num:nums){
            count[num]++;
        }
        for(int i=1; i<=100; i++){
            count[i]+=count[i-1];
        }
        for(int i=0; i<nums.length; i++){
            nums[i]=nums[i]==0? 0:count[nums[i]-1];
        }
        return nums;
    }
}
