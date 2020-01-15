/*
LeetCode Problem No.39:     https://leetcode.com/problems/combination-sum/
Author:                     zhangyixing1007
Idea:                       sort array, add from the smallest to largest until exceeding target
Time:                       6 ms, beat 94.40%
Space:                      38.1MB, beat 93.19%
*/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (target==0||candidates==null||candidates.length==0) return list;
        Arrays.sort(candidates);
        for (int i = 0; i<candidates.length; i++){
            solution.push(candidates[i]);
            helper(target-candidates[i], i, candidates);
            solution.pop();
        }
        return list;
    }
    List<List<Integer>> list=new ArrayList<List<Integer>>(); 
    Stack<Integer> solution=new Stack<Integer>();
    void helper(int target, int start, int[] candidates){
        if (target==0) list.add(new ArrayList<>(solution));
        if (target>0){
            for (int i=start; i<candidates.length; i++){
                if (target-candidates[i]>=0){
                    solution.push(candidates[i]);
                    helper(target-candidates[i], i, candidates);
                    solution.pop();
                }
                else break;
            }
        }
    }
}
