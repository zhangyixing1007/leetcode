/*
LeetCode Problem No.621:    https://leetcode.com/problems/task-scheduler/
Author:                     zhangyixing1007
Idea:                       put most frequent one first
Time:                       3 ms, beat 88.10%
Space:                      38.2 MB, beat 93.89%
*/

class Solution {
    public int leastInterval(char[] tasks, int n) {   
        int[] count = new int[26];
        for (char c : tasks){
            count[c-'A']++;
        }
        Arrays.sort(count);
        int ans = (count[25]-1)*(n+1)+1;
        int i = 24;
        while(count[i] == count[25]){
            ans++;i--;
        }
        return Math.max(ans,tasks.length);
    }
}
