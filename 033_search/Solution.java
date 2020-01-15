/*
LeetCode Problem No.33:    https://leetcode.com/problems/search-in-rotated-sorted-array/
Author:                    zhangyixing1007
Idea:                      first find the rotation point by binary search, then find the target by binary search again
Time:                      1 ms, beat 99.18%
Space:                     36.3MB, beat 85.40%
*/

class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len==0) return -1;
        if (len==1) return nums[0]==target? 0:-1;
        
        int r = findRotation(nums,0,len-1);
        if (r==-1) return findTarget(nums,0,len-1, target);
        if (nums[0]>target) return findTarget(nums,r,len-1,target);
        else if (nums[0]<target) return findTarget(nums,0,r-1,target);
        else return 0;
    }
    
    private int findRotation(int[] nums, int a, int b)
    {
        if (b == a) return -1;
        
        // iteration is also okay here
        int m = (a+b)/2;
        if (nums[m]>nums[m+1]) return m+1;
        else return (Math.max(findRotation(nums,a,m),findRotation(nums,m+1,b)));
    }
    
    private int findTarget(int[] nums, int a, int b, int target)
    {
        if (a==b) return nums[a]==target? a:-1;
        if (target>nums[b]||target<nums[a]) return -1;
        
        int m = (a+b)/2;
        if (nums[m]>target) return findTarget(nums,a,m,target);
        else if (nums[m]<target) return findTarget(nums,m+1,b,target);
        else return m;
    }
         
}
