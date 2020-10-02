/*
LeetCode Problem No.771:    https://leetcode-cn.com/problems/jewels-and-stones/
Author:                     zhangyixing1007
Idea:                       HashSet
Time:                       1 ms, beat 99.67%
Space:                      37.4 MB, beat 28.09%
*/

class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> gems=new HashSet<>();
        int ans=0;
        for(char c:J.toCharArray()){
            gems.add(c);
        }
        for(char c:S.toCharArray()){
            if(gems.contains(c)) ans++;
        }
        return ans;
    }
}
