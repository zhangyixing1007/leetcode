/*
LeetCode Problem No.131:    https://leetcode-cn.com/problems/palindrome-partitioning/
Author:                     zhangyixing1007
Idea:                       lopping, backtrack
Time:                       2 ms, beat 99.13%
Space:                      40.7 MB, beat 23.53%
*/

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list=new ArrayList<>();
        find(s, 0, new ArrayDeque<String>(), list);
        return list;
    }
    
    void find(String s, int curr, ArrayDeque<String> l, List<List<String>> list){
        if(curr==s.length()) {
            list.add(new ArrayList<String>(l)); return;
        }
        for(int j=curr; j<s.length(); j++){
            if(!isPalindrome(s, curr, j)) continue;
            l.addLast(s.substring(curr,j+1));
            find(s, j+1, l, list);
            l.removeLast();
        }
    }
    
    boolean isPalindrome(String t, int l, int r){
        while(l<=r&&t.charAt(l)==t.charAt(r)){
            l++; r--;
        }
        return l>=r;
    }
}
