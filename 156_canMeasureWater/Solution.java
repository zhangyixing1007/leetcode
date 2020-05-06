/*
LeetCode Problem No.156:    https://leetcode-cn.com/problems/water-and-jug-problem/
Author:                     zhangyixing1007
Idea:                       find gcd
Time:                       0 ms, beat 100%
Space:                      36.3 MB, beat 50%
*/

class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if(x==0||y==0) return z==0;
        if(z==0) return true;
        if(x+y<z) return false;
        int big=Math.max(x,y);
        int small=Math.min(x,y);
        while(big%small!=0){
            int temp=small;
            small=big%small;
            big=temp;
        }
        return z%small==0;
    }
}
