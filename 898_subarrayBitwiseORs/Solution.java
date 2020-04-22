/*
LeetCode Problem No.898:    https://leetcode.com/problems/bitwise-ors-of-subarrays/
Author:                     zhangyixing1007
Idea:                       3 HashSet
Time:                       500 ms, beat 28.86%
Space:                      67.3MB, beat 100%
*/

class Solution {
    public int subarrayBitwiseORs(int[] nums) {
        Set<Integer> ans=new HashSet<>();
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            Set<Integer> set2=new HashSet<>();
            for(int i:set) set2.add(i|num);
            set2.add(num);
            set=set2;
            for(int i:set) ans.add(i);
        }
        return ans.size();
    }
}
