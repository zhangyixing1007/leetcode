/*
LeetCode Problem No.022:    https://leetcode.com/problems/generate-parentheses/
Author:                     zhangyixing1007
Idea:                       recursion
Time:                       1 ms, beat 99.56%
Space:                      36.1 MB, beat 79.29%
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        add("", 0, 0, n);
        return list;
    }
    List<String> list=new ArrayList<>();
    void add(String s, int count1, int count2, int n){
        if(count1==count2&&count1<n){
            s+="(";
            add(new String(s), count1+1, count2, n);
        }else if (count1==n){
            while (count2<n){
                s+=")"; count2++;
            }
            list.add(new String(s));
        }else{
            add(new String(s+"("), count1+1, count2, n);
            add(new String(s+")"), count1, count2+1, n);
        }
    }
}
