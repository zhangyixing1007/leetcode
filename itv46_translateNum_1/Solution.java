/*
LeetCode Problem itv46:     https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
Author:                     zhangyixing1007
Idea:                       recursion, num2str
Time:                       0 ms, beat 100%
Space:                      36.1 MB, beat 100%
*/

class Solution {
    public int translateNum(int num) {
        if(num<0) return 0;
        if(num/10==0) return 1;
        if(num/100==0) return num<26? 2:1;
        String s=Integer.toString(num);
        int first=1;
        int second=Integer.parseInt(s.substring(0,2))<26
            &&s.charAt(0)!='0'? 2:1;
        for(int i=2; i<s.length(); i++){
            int t=second;
            second+=Integer.parseInt(s.substring(i-1,i+1))<26&&s.charAt(i-1)!='0'? first:0;
            first=t;
        }
        return second;
    }
    int[] record;
}
