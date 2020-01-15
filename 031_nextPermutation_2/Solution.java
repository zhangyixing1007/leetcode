/*
LeetCode Problem No.31:    https://leetcode.com/problems/next-permutation/
Author:                    zhangyixing1007
Idea:                      similar as Version 1, applying reverse and swap
Time:                      1 ms, beat 100%
Space:                     41.4MB, beat 62.74%
*/

class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length==0 || nums.length==1) return;
        int i = nums.length-2;
        while (i>=0 && nums[i]>=nums[i+1]) i--;
        this.nums = nums;
        if (i!=-1) {
            int j = nums.length-1;
            while (j-1>=0 && nums[j]<=nums[i]) j--;
            swap(i,j);
        }
        reverse(i+1);
    }
    int[] nums;
    void reverse (int start){
        int end = nums.length-1;
        while (start<end){
            swap(start,end);
            start++; end--;
        }
    }
    void swap(int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
