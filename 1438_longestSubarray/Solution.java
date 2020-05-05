/*
LeetCode Problem No.1438:   https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
Author:                     zhangyixing1007
Idea:                       sliding window + record max/min index
Time:                       4 ms, beat 100%
Space:                      48.7 MB, beat 100%
*/

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        if(nums==null||nums.length==0) return 0;
        int l=0, r=0, ans=0;
        int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
        int maxPos=0, minPos=0;
        int n=nums.length;
        for(;l<n&&r<n;){
            if(max<=nums[r]){
                max=nums[r];maxPos=r;
            }
            if(min>=nums[r]){
                min=nums[r];minPos=r;
            }           
            if(max-min<=limit) ans=Math.max(ans,r-l+1);
            else{
                if(maxPos<minPos){
                    l=maxPos+1;max=min;
                    for(int i=l; i<=r; i++){
                        if(max<=nums[i]){
                            max=nums[i];maxPos=i;
                        }
                    }
                }else{
                    l=minPos+1;min=max;
                    for(int i=l; i<=r; i++){
                        if(min>=nums[i]){
                            min=nums[i];minPos=i;
                        }   
                    }                    
                }
            }
            r++;
        }
        return ans;
    }
}
