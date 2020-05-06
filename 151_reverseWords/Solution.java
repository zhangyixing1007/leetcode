/*
LeetCode Problem No.151:    https://leetcode.com/problems/reverse-words-in-a-string/
Author:                     zhangyixing1007
Idea:                       Collections
Time:                       7 ms, beat 51.06%
Space:                      39.9 MB, beat 5.26%
*/

class Solution {
    public String reverseWords(String s) {
        List<String> list=Arrays.asList(s.split("\\s+"));
        Collections.reverse(list);
        return String.join(" ",list).trim();
    }
}
