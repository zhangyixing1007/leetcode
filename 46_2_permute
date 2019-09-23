/*
LeetCode Problem No.46:    https://leetcode.com/problems/permutations/
Author:                    zhangyixing1007
Idea:                      enumerate all the permutation, apply +1-1 = 0 to save space
Time:                      1 ms, beat 100%
Space:                     38.3MB, beat 73.77%
*/


class Solution {
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> numsList = new ArrayList();
        for (Integer num : nums)
            numsList.add(num);
        backtrack(numsList,output,0);
        return output;
    }
    
    private void backtrack(List<Integer> nums, List<List<Integer>> output, int first)
    {
        if (first == nums.size()) output.add(new ArrayList<Integer>(nums));
    
        for (int i = first; i < nums.size(); i++)
        {
            Collections.swap(nums,first,i);
            backtrack(nums, output, first+1);
            Collections.swap(nums,first,i);
        }
    }
}
