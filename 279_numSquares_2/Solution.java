/*
LeetCode Problem No.279:    https://leetcode.com/problems/perfect-squares/
Author:                     zhangyixing1007
Idea:                       BFS
Time:                       15 ms, beat 96.23%
Space:                      36 MB, beat 39.77%
*/

class Solution {
    public int numSquares(int n) {
        int[] ans=new int[n+1];
        Queue<Integer> q=new LinkedList<>();
        q.add(n);
        while (!q.isEmpty()){
            int curr=q.poll();
            for (int i=1; i*i<=curr; i++){
                if(i*i==curr) return ans[curr]+1;
                if (ans[curr-i*i]==0){
                    ans[curr-i*i]=ans[curr]+1; 
                    q.add(curr-i*i);
                }               
            }
        }
        return 0;
    }
}
