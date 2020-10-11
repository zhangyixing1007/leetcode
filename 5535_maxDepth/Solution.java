/*
LeetCode Problem No.5535:   https://leetcode-cn.com/problems/maximum-nesting-depth-of-the-parentheses/
Author:                     zhangyixing1007
Idea:                       +1-1
Time:                       1 ms
Space:                      36.8 MB
*/

class Solution {
    public int maxDepth(String s) {
        int ans=0, curr=0;
        for(char c:s.toCharArray()){
            if(c=='(') curr++;
            else if(c==')') curr--;
            ans=Math.max(ans, curr);
        }
        return ans;
    }
}
