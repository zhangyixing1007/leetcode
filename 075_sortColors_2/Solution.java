/*
LeetCode Problem No.75:     https://leetcode.com/problems/sort-colors/
Author:                     zhangyixing1007
Idea:                       left and right pointers, Version 2
Time:                       0 ms, beat 100%
Space:                      35.3 MB, beat 36.15%
*/

class Solution {
    public void sortColors(int[] nums) 
    {
        int left = 0;
        int right = nums.length-1;
        int i = left;
        while (i<=right)
        {
            if (nums[i] == 0)
            {
                int tmp = nums[i];
                nums[i++] = nums[left];
                nums[left++] = tmp;
            }
            else if (nums[i] == 2)
            {
                int tmp = nums[i];
                nums[i] = nums[right];
                nums[right--] = tmp;
            }
            else{i++;}
        }
    }
}
