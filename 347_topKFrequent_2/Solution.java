/*
LeetCode Problem No.347:    https://leetcode.com/problems/top-k-frequent-elements/
Author:                     zhangyixing1007
Idea:                       PriorityQueue
Time:                       69 ms, beat 30.78%
Space:                      40.6 MB, beat 96.12%
*/

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map <Integer,Integer> map = new HashMap<>();
        for (int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        PriorityQueue<Integer> q = new PriorityQueue<>((o1,o2) -> map.get(o1)-map.get(o2));
        
        for (int num:map.keySet()){
            q.add(num);
            if (q.size()>k)
                q.poll();
        }
        
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll());
        }
        Collections.reverse(ans);
        return ans;
    }
}
