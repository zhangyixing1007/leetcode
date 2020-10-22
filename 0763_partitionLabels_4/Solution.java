/*
LeetCode Problem No.0763:   https://leetcode-cn.com/problems/partition-labels/
Author:                     zhangyixing1007
Idea:                       record last position, char[]
Time:                       3 ms, beat 96.93%
Space:                      37.1 MB, beat 93.59%
*/

class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] lastPos=new int[26];
        char[] chars=S.toCharArray();
        for(int i=0; i<S.length(); i++){
            lastPos[chars[i]-'a']=i;
        }
        int start=0, end=0, curr=0;
        List<Integer> ans=new ArrayList<>();
        while(curr<S.length()){
            end=Math.max(end, lastPos[chars[curr]-'a']);
            if(end==curr){
                ans.add(end-start+1);
                start=end+1;
            }
            curr++;
        }
        return ans;
    }
}
