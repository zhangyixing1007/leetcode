/*
LeetCode Problem No.0845:   https://leetcode-cn.com/problems/longest-mountain-in-array/
Author:                     zhangyixing1007
Idea:                       find key points
Time:                       3 ms, beat 69.39%
Space:                      39 MB, beat 98.41%
*/

// 山脉有重要的三个节点：左山脚，山峰，右山脚
// p的值表示一种状态
// p==0 正在寻找左山脚
// p==1 正在寻找山峰，已经找到左山脚
// p==2 正在寻找右山脚，已经找到左山脚、山峰
// prev 存储左山脚的坐标
class Solution {
    public int longestMountain(int[] A) {
        int p=0, prev=-1, ans=0;
        for(int i=0; i<A.length; i++){
            if(p==0){
                if(i+1<A.length && A[i]<A[i+1]){
                    prev=i; p=1;
                }
            }else if(p==1){
                if(i+1<A.length && A[i]>A[i+1]){
                    p=2;
                }else if(i+1<A.length && A[i]==A[i+1]){
                    p=0; 
                }
            }else if(p==2){
                if(i+1<A.length && A[i]<=A[i+1] || i==A.length-1){
                    ans=Math.max(ans, i-prev+1);
                    p=0; i--;
                }
            }
        }
        return ans;
    }
}
