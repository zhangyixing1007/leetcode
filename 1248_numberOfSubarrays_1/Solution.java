/*
LeetCode Problem No.1248:   https://leetcode.com/problems/count-number-of-nice-subarrays/
Author:                     zhangyixing1007
Idea:                       list save index of each odd number
Time:                       19 ms, beat 17.42%
Space:                      48.8 MB, beat 100%
*/

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        if(nums==null||nums.length==0) return 0;
        List<Integer> list=new ArrayList<>();
        list.add(-1);
        for(int i=0; i<nums.length; i++){
            if(nums[i]%2==1) list.add(i);
        }
        list.add(nums.length);
        if(list.size()<k+2) return 0;
        int ans=0;
        for(int i=1; i<=list.size()-k-1; i++){
            int l=list.get(i)-list.get(i-1);
            int r=list.get(i+k)-list.get(i+k-1);
            ans+=l*r;
        }
        return ans;
    }
}
