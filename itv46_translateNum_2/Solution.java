/*
LeetCode Problem itv46:     https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
Author:                     zhangyixing1007
Idea:                       recursion, no String
Time:                       0 ms, beat 100%
Space:                      36.1 MB, beat 100%
*/

class Solution {
    public int translateNum(int num) {
        if(num < 10) return 1;
        int ans = 0;
        ans += translateNum(num/10);
        if(num%100 <= 25 && num%100 != num%10)
            ans+=translateNum(num/100);
        return ans;
    }
}
