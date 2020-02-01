/*
LeetCode Problem No.347:    https://leetcode.com/problems/top-k-frequent-elements/
Author:                     zhangyixing1007
Idea:                       PriorityQueue
Time:                       69 ms, beat 30.78%
Space:                      40.6 MB, beat 96.12%
*/

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for (int num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        Queue<Integer> q=new PriorityQueue<>((n1,n2)->map.get(n1)-map.get(n2));
        for (int key:map.keySet()){
            q.add(key);
            if(q.size()>k) q.poll();
        }
        List<Integer> ans=new ArrayList<>();
        while (!q.isEmpty()){
            ans.add(q.poll());
        }        
        return ans;
    }
}
