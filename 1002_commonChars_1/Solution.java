/*
LeetCode Problem No.1002:   https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
Author:                     zhangyixing1007
Idea:                       HashMap, slow
Time:                       25 ms, beat 13.39%
Space:                      39 MB, beat 68.35%
*/

class Solution {
    public List<String> commonChars(String[] A) {
        Map<Character, Integer> sum=new HashMap<>();
        Map<Character, Integer> curr=new HashMap<>();
        for(int i=0; i<A.length; i++){
            curr.clear();
            for(char c:A[i].toCharArray()){
                curr.put(c, curr.getOrDefault(c, 0)+1);
            }
            for(int j=0; j<26; j++){
                sum.put((char)(j+'a'), Math.min(sum.getOrDefault((char)(j+'a'), Integer.MAX_VALUE), curr.getOrDefault((char)(j+'a'), 0)));
            }
        }
        List<String> ans=new ArrayList<>();
        for(char c:sum.keySet()){
            int k=sum.get(c);
            while(k-->0){
                ans.add(c+"");
            }
        }
        return ans;
    }
}
