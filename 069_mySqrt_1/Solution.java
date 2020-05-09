/*
LeetCode Problem No.069:    https://leetcode-cn.com/problems/sqrtx/
Author:                     zhangyixing1007
Idea:                       binarysearch
Time:                       1 ms, beat 100%
Space:                      36.5 MB, beat 5.55%
*/

class Solution {
    public int mySqrt(int x) {
        if(x==0) return 0;
        int l=0, r=x;
        int ans=0;
        while(l<=r){
            //筛选条件中等号不可删去
            //l=ans+1,l比ans要大一些，即使l==r,也不代表已经搜索完毕了
            int mid=(l+r)/2;
            if((long) mid*mid<=x) {
                ans=mid; //只有符合要求才能赋值
                l=mid+1; //为跳出循环做准备
            }
            else r=mid-1; //mid*mid>x,那么mid一定不是我们所需要的值，r=mid+1是十分保险的
        }
        return ans;
    }
}
