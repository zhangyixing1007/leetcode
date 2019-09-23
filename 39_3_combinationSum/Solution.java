/*
LeetCode Problem No.39: https://leetcode.com/problems/combination-sum/
Author: zhangyixing1007
Idea: sort array, add from the smallest to largest until exceeding target
time: 6 ms, beat 94.40%
space: 38.1MB, beat 93.19%
*/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        
        if (candidates.length == 0) return list;
        if (target == 0) {list.add(new ArrayList<Integer>()); return list;}
        
        Arrays.sort(candidates);
        Stack<Integer> solution = new Stack<>();
        backtrack(solution, target, list, candidates, 0);
        
        return list;
    }
    
    private void backtrack(Stack<Integer> solution, int target, List<List<Integer>> list, int[]candidates, int start)
    {
        if (target==0) {list.add(new ArrayList(solution));}
        
        if (start < candidates.length)
        {
            for (int i = start; i < candidates.length; i++)
            {
                if (target - candidates[i] >= 0)
                {
                    solution.push(candidates[i]);
                    backtrack(solution, target - candidates[i], list,candidates, i);
                    solution.pop();
                }
                else{break;}
            }
        }
    }
}
