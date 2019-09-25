/*
LeetCode Problem No.39:     https://leetcode.com/problems/combination-sum/
Author:                     zhangyixing1007
Idea:                       add one number again and again until can not any more
*/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        
        if (candidates.length == 0) return list;
        if (target == 0) {list.add(new ArrayList<Integer>()); return list;}
        
        for (int i = 0; i <= target/candidates[0]; i++)
        {
            List<Integer> solution = new ArrayList<>();
            int count = i;
            while (count!=0) {solution.add(candidates[0]); count--;}
            backtrack(solution,target - i*candidates[0],list,1, candidates);
        }
        return list;
    }
    
    private void backtrack(List<Integer> sol, int target, List<List<Integer>> list, int focus, int[]candidates)
    {
        if (target==0) {list.add(sol);}
        
        if (focus<candidates.length && target>0)
        {
            for (int i = 0; i <= target/candidates[focus]; i++)
            {
                List<Integer> solution = new ArrayList<>(sol);
                int count = i;
                while (count!=0) {solution.add(candidates[focus]); count--;}
                backtrack(solution,target - i*candidates[focus],list,focus+1,candidates);
            }    
        }
    }
}
