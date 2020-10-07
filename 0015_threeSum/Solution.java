/*
LeetCode Problem No.0015:   https://leetcode.com/problems/3sum/
Author:                     zhangyixing1007
Idea:                       two-pointers, avoid repeat
Time:                       23 ms, beat 84.83%
Space:                      42.8 MB, beat 54.54%
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums==null||nums.length<3) return new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0; i+2<n; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;//对i去重
            if(nums[i]>0) break;//一开始就大了 没有必要继续了
            if(nums[i]+nums[n-2]+nums[n-1]<0) continue;//说明i小了 直接跳出本次循环
            // left，right双指针，结果<target则left右移，>target则right左移
            int left=i+1, right=n-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==0){
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left<right && nums[left]==nums[left+1]) left++;
                    left++;//之前left指向的是最后一个重复值 所以这里要再来一次到达新值
                    while(right>left && nums[right]==nums[right-1]) right--;
                    right--;//之前right指向的是最后一个重复值 所以这里要再来一次到达新值
                }else if(sum<0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return ans;
    }
}
