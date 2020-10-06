/*
LeetCode Problem No.0018:   https://leetcode-cn.com/problems/4sum/
Author:                     zhangyixing1007
Idea:                       two pointers, similar to 0015
Time:                       3 ms, beat 99.98%
Space:                      39.3 MB, beat 49.58%
*/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums==null||nums.length<4) return new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0; i+3<n; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;//对i去重
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target) break;//一开始就大了 没有必要继续了
            if(nums[i]+nums[n-3]+nums[n-2]+nums[n-1]<target) continue;//说明i小了 直接跳出本次循环
            for(int j=i+1; j+2<n; j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;//对j去重
                if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>target) break;//一开始就大了 没有必要继续了
                if(nums[i]+nums[j]+nums[n-2]+nums[n-1]<target) continue;//说明j小了 直接跳出本次循环
                // left，right双指针，结果<target则left右移，>target则right左移
                int left=j+1, right=n-1;
                while(left<right){
                    if(nums[i]+nums[j] +nums[left]+nums[right]==target){
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(left<right && nums[left]==nums[left+1]) left++;
                        left++;//之前left指向的是最后一个重复值 所以这里要再来一次到达新值
                        while(right>left && nums[right]==nums[right-1]) right--;
                        right--;//之前right指向的是最后一个重复值 所以这里要再来一次到达新值
                    }else if(nums[i]+nums[j]+nums[left]+nums[right]<target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}
