/*
LeetCode Problem No.1434:   https://leetcode-cn.com/problems/number-of-ways-to-wear-different-hats-to-each-other/
Author:                     zhangyixing1007
Idea:                       state compress dynamic programming
Time:                       31 ms, beat 66.67%
Space:                      40 MB, beat 100%
*/

class Solution {
    public int numberWays(List<List<Integer>> hats) {
        int n=hats.size();
        int N=1000000007;
        int maxHat=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<hats.get(i).size(); j++){
                maxHat=Math.max(maxHat,hats.get(i).get(j));
            }
        }
        List<List<Integer>> people=new ArrayList<>();
        for(int i=0; i<maxHat; i++){
            people.add(new ArrayList<Integer>());
        }        
        for(int i=0; i<n; i++){
            for(int j=0; j<hats.get(i).size(); j++){
                people.get(hats.get(i).get(j)-1).add(i);
            }
        }        
        int[][] dp=new int[maxHat+1][1<<n];
        dp[0][0]=1;
        for(int i=1; i<=maxHat; i++){
            List<Integer> list=people.get(i-1);
            for(int j=0; j<(1<<n); j++){
                dp[i][j]=dp[i-1][j];
                for(Integer k:list){
                    if((j&(1<<k))!=0){
                        dp[i][j]+=dp[i-1][j-(j&(1<<k))];
                        dp[i][j]%=N;
                    }                    
                }
            }
        }
        return dp[maxHat][(1<<n)-1];
    }
}
