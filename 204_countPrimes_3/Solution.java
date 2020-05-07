/*
LeetCode Problem No.204:    https://leetcode-cn.com/problems/count-primes/
Author:                     zhangyixing1007
Idea:                       Sieve of Euler
Time:                       31 ms, beat 31.29%
Space:                      50.4 MB, beat 5.72%
*/

class Solution {
    public int countPrimes(int n) {
        if(n<2) return 0;
        int[] visited=new int[n];
        visited[0]=1; visited[1]=1;
        int[] prime=new int[n];
        int count=0;
        for(int i=2; i<n; i++){
            if(visited[i]==0) prime[count++]=i;
            for(int j=0; j<=count&&i*prime[j]<n; j++){
                visited[i*prime[j]]=1;
                if(i%prime[j]==0) break;
            }
        }
        return count;
    }
}
