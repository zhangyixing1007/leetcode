/*
LeetCode Problem No.39:    https://leetcode.com/problems/permutations/
Author:                    zhangyixing1007
Idea:                      enumerate all the permutation, apply +1-1 = 0 to save space
Time:                      45 ms, beat 5.10%
Space:                     36.6MB, beat 93.95%
*/


class Solution {
    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        if (n==0) {list.add(new ArrayList(){}); return list;}
        if (n==1) {list.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));return list;}
        
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        list.add(numsList);
        addNext(numsList,n-2);     
        return list;
    }
    
    private List<List<Integer>>  list = new ArrayList<List<Integer>>();
    private int n;
                 
    private void addNext(List<Integer> numsList, int focus)
     {
         if (focus > -1)
         {
             addNext(numsList,focus-1);
             for (int i = focus + 1; i < n; i++)
             {
                 List<Integer> nnList = new ArrayList<>();
                 for (Integer in : numsList) nnList.add(in);
                 Integer tmp = nnList.get(i); nnList.set(i,nnList.get(focus)); nnList.set(focus,tmp);
                 list.add(nnList);
                 addNext(nnList,focus-1);
             }
         }
     }
}
