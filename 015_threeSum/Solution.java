/*
LeetCode Problem No.015:    https://leetcode.com/problems/3sum/
Author:                     zhangyixing1007
Idea:                       avoid repeat
Time:                       32 ms, beat 95.52%
Space:                      46 MB, beat 92.53%
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++){
            int l=i+1, r=nums.length-1;
            if(nums[i]>0) break;
            if(i>0&&i<nums.length&&nums[i]==nums[i-1]) continue;
            int sum=-1;
            while(l<r){
                sum=nums[i]+nums[l]+nums[r];
                if(sum>0) r--;
                else if (sum<0) l++;
                else{
                    list.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[l],nums[r])));
                    while(l<r&&nums[l]==nums[l+1]) l++;
                    while(l<r&&nums[r]==nums[r-1]) r--;
                    l++;r--;
                }
            }
        }
        return list;
    }
}
