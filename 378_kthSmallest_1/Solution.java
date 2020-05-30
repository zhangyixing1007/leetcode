/*
LeetCode Problem No.378:    https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
Author:                     zhangyixing1007
Idea:                       PriorityQueue
Time:                       19 ms, beat 38.51%
Space:                      44.7 MB, beat 15.38%
*/

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return 0;
        PriorityQueue<Integer> pq=new PriorityQueue<>((o1, o2)-> o2-o1);
        for(int i=0; i<Math.min(k, matrix.length); i++){
            for(int j=0; i+j<k&&j<matrix[0].length; j++){
                if(pq.size()==k&&matrix[i][j]>=pq.peek()) break;
                pq.add(matrix[i][j]);
                if(pq.size()>k) pq.poll();
            }
        }
        return pq.peek();
    }
}
