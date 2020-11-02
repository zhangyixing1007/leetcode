/*
LeetCode Problem No.0941:   https://leetcode-cn.com/problems/valid-mountain-array/
Author:                     zhangyixing1007
Idea:                       one time linear scan
Time:                       1 ms, beat 100%
Space:                      39.2 MB, beat 97.75%
*/

class Solution {
    public boolean validMountainArray(int[] A) {
        if(A==null || A.length<3) return false;
        int l=0, r=A.length-1;
        while(l+1<A.length && A[l]<A[l+1]) l++;
        while(r-1>=0 && A[r]<A[r-1]) r--;
        return l==r && l!=0 && r!=A.length-1;
    }
}
