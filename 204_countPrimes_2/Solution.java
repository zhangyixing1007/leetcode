/*
LeetCode Problem No.204:    https://leetcode-cn.com/problems/count-primes/
Author:                     zhangyixing1007
Idea:                       Sieve of Eratosthenes variant, only odd
Time:                       10 ms, beat 97.60%
Space:                      38.2 MB, beat 8.57%
*/

class Solution {
    public int countPrimes(int n) {
        int ans=0;
        boolean[] visited=new boolean[n];
        if(n>2) ans++;
        for(int i=3; i<n; i+=2){
            if(!visited[i]) ans++;
            for(int j=3; i*j<n; j+=2){
                visited[i*j]=true;
            }
        }
        return ans;
    }
}
