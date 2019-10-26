/*
LeetCode Problem No.494:    https://leetcode.com/problems/target-sum/
Author:                     zhangyixing1007
Idea:                       brute force
Time:                       over time
Space:                      unknown
*/

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int ans = 0;
        for (int i = 0; i < 1<<nums.length; i++){
            int t = i;
            int sum = 0;
            for (int j = 0; j < nums.length; j++){
                if (t%2 == 1){
                    sum += nums[j];
                } else {
                    sum -= nums[j];
                }
                t = t>>1;
            }
            if (sum == S) ans++;
        }
        return ans;
    }
}
