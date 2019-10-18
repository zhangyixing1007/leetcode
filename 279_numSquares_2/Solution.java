/*
LeetCode Problem No.279:    https://leetcode.com/problems/perfect-squares/
Author:                     zhangyixing1007
Idea:                       dynamic programming, only calculate useful one, or say, BFS
Time:                       15 ms, beat 96.23%
Space:                      36 MB, beat 39.77%
*/

class Solution
{
    public int numSquares(int n)
    {
        int [] ans = new int [n+1];
        ans[n] = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        while (!q.isEmpty())
        {
            int curr = q.poll();
            
            int i = 1;
            while (true)
            {
                if (curr-i*i<0) break;
                if (curr-i*i == 0) return ans[curr]+1;
                if (ans[curr-i*i]==0) {ans[curr-i*i] = ans[curr]+1;q.add(curr-i*i);}
                i++;
            }
            
        }
        return -1;
    }
}
