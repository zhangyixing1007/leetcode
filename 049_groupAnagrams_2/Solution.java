/*
LeetCode Problem No.49:     https://leetcode.com/problems/group-anagrams/
Author:                     zhangyixing1007
Idea:                       make good use of HashMap, sort, conversion between char[] and String
Time:                       16 ms, beat 88.71%
Space:                      40.4 MB, beat 99.55%
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map=new HashMap<>();
        for (String str:strs){
            char[] c=str.toCharArray();
            Arrays.sort(c);
            String s=String.valueOf(c);
            if(map.containsKey(s))
                map.get(s).add(str);
            else
                map.put(s,new ArrayList(Arrays.asList(str)));
        }
        return new ArrayList(map.values());
    }
}
