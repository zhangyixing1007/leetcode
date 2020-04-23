/*
LeetCode Problem No.31:    https://leetcode.com/problems/next-permutation/
Author:                    zhangyixing1007
Idea:                      find the first descending point -- if no such one, then it is the largest -- and apply math knowledge
Time:                      1 ms, beat 100%
Space:                     37.3MB, beat 88.26%
*/

class Solution {
    public void nextPermutation(int[] nums) {       
        int n = nums.length;
        if (n>=2)
        {
            int i = n-1;
            while (i>0 && nums[i-1]>=nums[i]) i--;
            if (i==0)
            {
                for (int j = 0; j < n/2; j++)
                {
                    int tmp = nums[j];
                    nums[j] = nums[n - j - 1];
                    nums[n - j - 1] = tmp;
                }
            }
            else
            {
                i = i - 1;
                int exchange = i, minmax = Integer.MAX_VALUE;
                for (int j = i + 1; j < n; j++)
                {
                    if(nums[i]<nums[j])
                    {
                        minmax = Math.min(minmax,nums[j]);
                        exchange = j;
                    }
                }
                int tmp = nums[i];
                nums[i] = nums[exchange];
                nums[exchange] = tmp;
                int [] copy = new int[n-i-1];
                Arrays.sort(nums,i+1,nums.length);
            }
        }
    }
}
