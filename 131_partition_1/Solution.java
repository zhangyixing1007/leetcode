/*
LeetCode Problem No.131:    https://leetcode-cn.com/problems/palindrome-partitioning/
Author:                     zhangyixing1007
Idea:                       brute force, backtrack
Time:                       19 ms, beat 6.17%
Space:                      40.5 MB, beat 29.41%
*/

class Solution {
    public List<List<String>> partition(String s) {
        list=new ArrayList<>();
        find(s, "", 0, new ArrayList<String>());
        return list;
    }
    List<List<String>> list;
    
    void find(String s, String t, int curr, List<String> l){
        if(curr==s.length()) {
            if(t.length()==0) list.add(l);
            return;
        }
        t=t+s.substring(curr,curr+1);
        List<String> l2=new ArrayList<String>(l);
        if(t.length()!=0&&isPalindrome(t)){
            l.add(t);
            find(s, "", curr+1, l);
        }
        find(s, t, curr+1, l2);
    }
    
    boolean isPalindrome(String t){
        int l=0, r=t.length()-1;
        while(l<=r&&t.charAt(l)==t.charAt(r)){
            l++; r--;
        }
        return l>=r;
    }
}
