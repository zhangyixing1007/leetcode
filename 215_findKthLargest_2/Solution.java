/*
LeetCode Problem No.215:    https://leetcode.com/problems/kth-largest-element-in-an-array/
Author:                     zhangyixing1007
Idea:                       use PriorityQueue
Time:                       6 ms, beat 29.16%
Space:                      88.65 MB, beat 94.18%
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((n1,n2)->n1-n2);
        for (int num:nums){
            q.add(num);
            if (q.size()>k) q.poll();
        }
        return q.poll();
    }
}
