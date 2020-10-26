/*
LeetCode Problem No.1365:   https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
Author:                     zhangyixing1007
Idea:                       sort + binarySearch
Time:                       4 ms, beat 73.11%
Space:                      38.5 MB, beat 95.35%
*/

class Solution {  
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] tmp=new int[nums.length];
        System.arraycopy(nums, 0, tmp, 0, tmp.length);
        Arrays.sort(tmp);
        for(int i=0; i<nums.length; i++){
            nums[i]=binarySearch(tmp, nums[i]);
        }
        return nums;
    }
    int binarySearch(int[] tmp, int target){
        int left=0, right=tmp.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(tmp[mid]<target){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }
}
