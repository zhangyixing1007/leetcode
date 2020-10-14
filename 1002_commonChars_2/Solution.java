/*
LeetCode Problem No.1002:   https://leetcode-cn.com/problems/find-common-characters/
Author:                     zhangyixing1007
Idea:                       int[], fast
Time:                       3 ms, beat 98.36%
Space:                      38.6 MB, beat 98.67%
*/

class Solution {
    public List<String> commonChars(String[] A) {
        int[] sum=new int[26]; Arrays.fill(sum, Integer.MAX_VALUE);
        int[] curr=new int[26];
        for(int i=0; i<A.length; i++){
            Arrays.fill(curr, 0);
            for(char c:A[i].toCharArray()){
                curr[c-'a']++;
            }
            for(int j=0; j<26; j++){
                sum[j]=Math.min(sum[j], curr[j]);
            }
        }
        List<String> ans=new ArrayList<>();
        for(int j=0; j<26; j++){
            while(sum[j]-->0){
                ans.add(Character.toString(j+'a'));
            }
        }
        return ans;
    }
}
