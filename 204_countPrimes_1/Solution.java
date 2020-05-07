/*
LeetCode Problem No.204:    https://leetcode-cn.com/problems/count-primes/
Author:                     zhangyixing1007
Idea:                       Sieve of Eratosthenes
Time:                       32 ms, beat 30.02%
Space:                      50.4 MB, beat 5.72%
*/

class Solution {
    public int countPrimes(int n) {
        if(n<2) return 0;
        int[] visited=new int[n];
        visited[0]=1; visited[1]=1;
        int count=0;
        for(int i=2; i<n; i++){
            if(visited[i]==1) continue;
            if(visited[i]==0) count++;
            for(int j=0; i*j<n; j++){
                visited[i*j]=1;
            }
        }
        return count;
    }
}
