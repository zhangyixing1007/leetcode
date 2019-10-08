/*
LeetCode Problem No.78:     https://leetcode.com/problems/subsets/
Author:                     zhangyixing1007
Idea:                       List to keep record
Time:                       1 ms, beat 99.83%
Space:                      36.7 MB, beat 46.65%
*/

class Solution
{
    public List<List<Integer>> subsets(int[] nums)
    {
        List<Integer> l = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        list.add(l);
        for (int b : nums)
        {
            int n = list.size();
            for (int i = 0; i < n; i++)
            {                
                List<Integer> s = list.get(i);                
                List<Integer> t = new ArrayList<>(s);
                t.add(b);
                list.add(t);
            }
        }
        return list;
    }
}
