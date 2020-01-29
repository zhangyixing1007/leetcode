/*
LeetCode Problem No.215:    https://leetcode.com/problems/kth-largest-element-in-an-array/
Author:                     zhangyixing1007
Idea:                       quickSort
Time:                       2 ms, beat 99.22%
Space:                      32.7 MB, beat 94.63%
*/

class Solution
{
    public int findKthLargest(int[] nums, int k)
    {
        if (k<=0 || nums.length==0 || k > nums.length) return -1;
        this.nums = nums;
        return findPos(k-1, 0, nums.length-1);
    }
    
    private int[] nums;
    
    private void swap(int i, int j)
    {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;        
    }
    
    private int findPos(int k, int left, int right)
    {
        if(left>right) return -1;
        if(left == right) return nums[left];
        
        Random random = new Random();
        int mid = random.nextInt(right-left+1)+left;//right is not included here
        swap(mid,right);
        int j = left;
        for (int i = left; i < right; i++)
        {
            if(nums[i]>nums[right])
            {
                swap(i,j);
                j++;
            }
        }
        swap(j,right);
        
        if (j == k) return nums[j];
        else if (j < k) return findPos(k,j+1,right);
        else return findPos(k,left,j-1);
    }
}
