/*
LeetCode Problem No.438:    https://leetcode.com/problems/find-all-anagrams-in-a-string/
Author:                     zhangyixing1007
Idea:                       sliding window, use int[] to record the info in the sliding window
Time:                       10 ms, beat 80.80%
Space:                      38.2 MB, beat 67.08%
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(p==null||s==null||p.length()==0||s.length()==0
           ||p.length()>s.length()) 
            return new ArrayList<Integer>();
        int[] record=new int[26];
        List<Integer> list=new ArrayList<>();
        int sum=0;
        for(int i=0; i<p.length(); i++){
            char c=p.charAt(i);
            record[c-'a']++; sum++;
        }
        for(int i=0; i<p.length(); i++){
            char c=s.charAt(i);
            record[c-'a']--; 
            if (record[c-'a']>=0) sum--;
        }
        if (sum==0) list.add(0);
        for (int i=p.length(); i<s.length(); i++){
            char c=s.charAt(i-p.length());
            record[c-'a']++;
            if (record[c-'a']>0) sum++;
            c=s.charAt(i);
            record[c-'a']--; 
            if (record[c-'a']>=0) sum--;
            if (sum==0) list.add(i-p.length()+1);
        }
        return list;
    }
}
