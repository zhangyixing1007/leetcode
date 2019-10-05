/*
LeetCode Problem No.75:     https://leetcode.com/problems/sort-colors/
Author:                     zhangyixing1007
Idea:                       left and right pointers, verbose version
Time:                       0 ms, beat 100%
Space:                      35.3 MB, beat 36.15%
*/

class Solution {
    public void sortColors(int[] nums) {
        if (nums.length>=2)
        {
            int left = 0, right = nums.length-1;
            while(left<nums.length&&nums[left]==0) left++;
            while(right>-1&&nums[right]==2) right--;

            for (int i = left; i <= right;)
            {
                if (nums[i] == 0) 
                {
                    if (i==left) {i++;left++;}
                    int tmp = nums[i];nums[i] = nums[left];nums[left++] = tmp;
                    if (nums[right] == 2) right--;
                }
                else if (nums[i] == 2)
                {
                    int tmp = nums[i];nums[i] = nums[right];nums[right--] = tmp;
                    if (nums[left] == 0) {left++; i++;}
                }
                else if (nums[i] == 1) i++;
            }
        }
    }
}
