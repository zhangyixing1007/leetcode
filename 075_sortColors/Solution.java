/*
LeetCode Problem No.75:     https://leetcode.com/problems/sort-colors/
Author:                     zhangyixing1007
Idea:                       left and right pointers
Time:                       0 ms, beat 100%
Space:                      35.3 MB, beat 36.15%
*/

class Solution {
    public void sortColors(int[] nums) {
        if(nums.length>=2){
            int l=0, r=nums.length-1;
            while(l<nums.length&&nums[l]==0) l++;
            while(r>-1&&nums[r]==2) r--;
            for(int i=l; i<r+1; ){
                if(nums[i]==0){
                    if (i==l) {i++;l++;}
                    int t=nums[i];nums[i]=nums[l];nums[l++]=t;
                } else if (nums[i]==2){
                    int t=nums[i];nums[i]=nums[r];nums[r--]=t;
                    if(nums[l]==0) {l++;i++;}                    
                } else i++;
            }
        }
    }
}
