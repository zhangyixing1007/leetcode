/*
LeetCode Problem No.96:     https://leetcode.com/problems/unique-binary-search-trees/
Author:                     zhangyixing1007
Idea:                       recursion, with saving
Time:                       0 ms, beat 100%
Space:                      32.8 MB, beat 85.45%
*/

class Solution {
    public int numTrees(int n) {    
        ans=new int[n+1];
        ans[0]=1;
        return helper(n);
    }
    int[] ans;
    int helper(int n){
        if (ans[n]!=0) return ans[n];
        int sum=0;
        for (int i=0; i<n; i++){
            sum+=helper(i)*helper(n-1-i);
        }        
        ans[n]=sum;
        return ans[n];
    }
}
