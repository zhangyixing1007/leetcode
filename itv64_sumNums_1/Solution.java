/*
LeetCode Problem itv64：    https://leetcode-cn.com/problems/qiu-12n-lcof/
Author:                     zhangyixing1007
Idea:                       &&
Time:                       1 ms, beat 66.05%
Space:                      36.7 MB, beat 100%
*/

class Solution {
    public int sumNums(int n) {
        boolean flag=n>0 && (n+=sumNums(n-1))>0;
        return n;
    }
}
