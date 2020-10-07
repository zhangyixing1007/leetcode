/*
LeetCode Problem No.0002:   https://leetcode-cn.com/problems/sort-colors/
Author:                     zhangyixing1007
Idea:                       scan and swap
Time:                       0 ms, beat 100%
Space:                      37.4 MB, beat 39.44%
*/

class Solution {
    public void sortColors(int[] nums){
        int left = 0;
        int right = nums.length-1;
        int i = left;
        while (i<=right){
            if (nums[i] == 0) {
                swap(nums, i, left); left++; i++;
            } else if (nums[i] == 2) {
                swap(nums, i, right); right--;
            } else {
                i++;
            }
        }
    }
    void swap(int[] nums, int i, int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}
