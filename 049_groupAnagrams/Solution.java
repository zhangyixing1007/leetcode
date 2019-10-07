/*
LeetCode Problem No.49:     https://leetcode.com/problems/group-anagrams/
Author:                     zhangyixing1007
Idea:                       the simplist brutal force, very very slow
Time:                       16 ms, beat 88.71%
Space:                      40.4 MB, beat 99.55%
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // List<List<String>> list = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs)
        {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String value = String.valueOf(c);
            if (map.containsKey(value)) map.get(value).add(str);
            else {map.put(value,new ArrayList<String>(Arrays.asList(str)));}
        }
        return new ArrayList<List<String>>(map.values());
    }
}
