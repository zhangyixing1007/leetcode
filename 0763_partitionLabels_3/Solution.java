/*
LeetCode Problem No.0763:   https://leetcode-cn.com/problems/partition-labels/
Author:                     zhangyixing1007
Idea:                       record last position, charAt()
Time:                       4 ms, beat 86.91%
Space:                      36.8 MB, beat 98.37%
*/

class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] lastPos=new int[26];
        for(int i=0; i<S.length(); i++){
            lastPos[S.charAt(i)-'a']=i;
        }
        int start=0, end=0, curr=0;
        List<Integer> ans=new ArrayList<>();
        while(curr<S.length()){
            end=Math.max(end, lastPos[S.charAt(curr)-'a']);
            if(end==curr){
                ans.add(end-start+1);
                start=end+1;
            }
            curr++;
        }
        return ans;
    }
}
