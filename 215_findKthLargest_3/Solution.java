/*
LeetCode Problem No.215:    https://leetcode.com/problems/kth-largest-element-in-an-array/
Author:                     zhangyixing1007
Idea:                       quickSort
Time:                       2 ms, beat 99.22%
Space:                      32.7 MB, beat 94.63%
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        this.nums=nums;
        return find(k-1, 0, nums.length-1);
    }
    int[] nums;
    void swap(int i, int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
    int find(int k, int left, int right){
        if(left==right) return nums[left];
        Random random = new Random();
        int mid=left+random.nextInt(right-left+1);
        swap(mid,right);
        int j=left;
        for(int i=left; i<right; i++){
            if(nums[i]>nums[right]){
                swap(i,j);
                j++;
            }
        }
        swap(j,right);
        if(j==k) return nums[k];
        else if (j<k) return find(k, j+1, right);
        else return find(k, left, j);
    }
}
