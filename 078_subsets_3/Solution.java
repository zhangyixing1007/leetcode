/*
LeetCode Problem No.78:     https://leetcode.com/problems/subsets/
Author:                     zhangyixing1007
Idea:                       backtrack, or say simply recursion
Time:                       1 ms, beat 99.83%
Space:                      35.9 MB, beat 74.86%
*/

class Solution
{
    public List<List<Integer>> subsets(int[] nums)
    {
        List<Integer> l = new ArrayList<>();
        list = new ArrayList<>();
        list.add(l);
        backtrack(l,0,nums);
        return list;
    }
    
    List<List<Integer>> list;
    
    private void backtrack(List<Integer> l, int now, int[] nums)
    {
        if (now<nums.length)
        {
            List<Integer> t = new ArrayList<>(l);
            t.add(nums[now]);
            list.add(t);
            backtrack(l,now+1,nums);
            backtrack(t,now+1,nums);
        }
    }   
}
