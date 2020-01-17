/*
LeetCode Problem No.438:    https://leetcode.com/problems/find-all-anagrams-in-a-string/
Author:                     zhangyixing1007
Idea:                       sliding window, use int[] to record the info in the sliding window
Time:                       7 ms, beat 99.40%
Space:                      38.1 MB, beat 93.80%
*/

class Solution { 
    public List<Integer> findAnagrams(String s, String p) { 
        List<Integer> list = new ArrayList<>(); 
         
        if(s.length()==0||p.length()==0||s.length()<p.length()) return list; 
         
        char[] sc = s.toCharArray(); 
        char[] pc = p.toCharArray(); 
        int[] record = new int[26]; 
         
        for (char c:pc) {record[c-'a']++;} 
        int l = 0, r = 0, rest = p.length(); 
         
        for (; r<p.length(); r++) { 
            char c = sc[r]; 
            record[c-'a']--; 
            if (record[c-'a']>=0) rest--; 
        } 
         
        if (rest==0) list.add(l); 
         
        while (r<s.length()) { 
            char c = sc[l++]; 
            if (record[c-'a']>=0) rest++; 
            record[c-'a']++; 
             
            c = sc[r]; 
            record[c-'a']--; 
            if (record[c-'a']>=0) rest--; 
            if (rest==0) list.add(l); 
            r++;     
        } 
        return list; 
    } 
} 
