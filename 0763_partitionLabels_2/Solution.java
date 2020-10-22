/*
LeetCode Problem No.0763:   https://leetcode-cn.com/problems/partition-labels/
Author:                     zhangyixing1007
Idea:                       count occurence
Time:                       10 ms, beat 28.46%
Space:                      37.1 MB, beat 94.64%
*/

class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] count=new int[26];
        for(char c:S.toCharArray()){
            count[c-'a']++;
        }
        List<Integer> ans=new ArrayList<>();
        Set<Integer> visited=new HashSet<>();
        int left=0;
        for(int i=0; i<S.length(); i++){
            int k=S.charAt(i)-'a';
            visited.add(k);
            count[k]--;
            if(count[k]==0){
                visited.remove(k);
            }
            if(visited.isEmpty()){
                ans.add(i-left+1);
                left=i+1;
            }
        }
        return ans;
    }
}
