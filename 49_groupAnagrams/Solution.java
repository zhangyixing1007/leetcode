/*
LeetCode Problem No.49:     https://leetcode.com/problems/jump-game/
Author:                     zhangyixing1007
Idea:                       brutal force
Time:                       600 ms, beat 5.02%
Space:                      41.5MB, beat 98.98%
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        if (strs.length==0)
        {return list;}

        List<String> t = new ArrayList<>();
        t.add(strs[0]);
        list.add(t);
        
        for (int i = 1; i < strs.length; i++)
        {
            String s0 = strs[i];
            int flag = 0;
            for (List<String> l:list)
            {                            
                String s = l.get(0);                
                if (s.length()!=s0.length())
                {continue;}
                      
                if (s.length()==0&&s0.length()==0)
                {l.add(s0);flag = 1; continue;}
                
                int[] tmp = new int[26];
                for (int j = 0; j < s.length(); j++)
                {
                    tmp[s.charAt(j)-'a']++;
                }               
                
                for (int j = 0; j < s0.length(); j++)
                {
                    tmp[s0.charAt(j)-'a']--;
                    if (tmp[s0.charAt(j)-'a']<0) break;
                    else if (j==s0.length()-1)
                    {l.add(s0); flag = 1;}
                }                
                 if (flag == 1) break;
            }
            if (flag == 0)
            {
                List<String> nlist = new ArrayList<>();
                nlist.add(s0);
                list.add(nlist);
            }
        }
        
        return list;
    }
}
