/*
LeetCode Problem No.78:     https://leetcode.com/problems/subsets/
Author:                     zhangyixing1007
Idea:                       queue to keep record
Time:                       1 ms, beat 99.83%
Space:                      36.1 MB, beat 64.41%
*/

class Solution
{
    public List<List<Integer>> subsets(int[] nums)
    {        
        Queue<List<Integer>> q = new LinkedList<>();
        List<Integer> l = new ArrayList<>();
        q.add(l);
        for (int b : nums)
        {
            while (true)
            {                
                List<Integer> s = q.poll();
                q.add(s);
                List<Integer> t = new ArrayList<>(s);
                t.add(b);
                q.add(t);
                if (q.peek().size()==0) break;
            }
        }
            
        List<List<Integer>> list = new ArrayList<>(q);
        return list;
    }
}
