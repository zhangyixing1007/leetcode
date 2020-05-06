/*
LeetCode Problem No.945:    https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/
Author:                     zhangyixing1007
Idea:                       +1-1
Time:                       10 ms, beat 85.26%
Space:                      43.9 MB, beat 100%
*/

class Solution {
    public int minIncrementForUnique(int[] A) {
        int[] count=new int[80000];
        for(int i:A) count[i]++;
        int ans=0, taken=0;
        for(int i=0; i<80000; i++){
            if(count[i]>1){
                taken+=count[i]-1;
                ans-=(count[i]-1)*i;
            }else if(taken>0&&count[i]==0){
                taken--; ans+=i;
            }
        }
        return ans;
    }
}
