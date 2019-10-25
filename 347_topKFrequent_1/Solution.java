/*
LeetCode Problem No.347:    https://leetcode.com/problems/top-k-frequent-elements/
Author:                     zhangyixing1007
Idea:                       bucket sort
Time:                       15 ms, beat 99.49%
Space:                      40.9 MB, beat 95.62%
*/

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map <Integer,Integer> map = new HashMap<>();
        for (int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        List[] list = new List[nums.length+1];
        for (int num:map.keySet()){
            int count = map.get(num);
            if (list[count]==null){
                list[count] = new ArrayList<Integer>();
            }
            list[count].add(num);
            // System.out.println(list[count].toString());
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int i = nums.length; k>0 ; i--){
            if (list[i]!=null&& list[i].size()<=k){
                ans.addAll(list[i]);
                k = k - list[i].size();
            }
        }
        return ans;
    }
}
