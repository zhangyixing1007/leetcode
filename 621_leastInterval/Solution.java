/*
LeetCode Problem No.621:    https://leetcode.com/problems/task-scheduler/
Author:                     zhangyixing1007
Idea:                       put most frequent one first
Time:                       3 ms, beat 88.10%
Space:                      38.2 MB, beat 93.89%
*/

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] record=new int[26];
        for(char c:tasks) record[c-'A']++;
        Arrays.sort(record);
        int ans=(record[25]-1)*(n+1)+1;
        int i=24;
        while(record[i--]==record[25]) ans++;
        return Math.max(ans,tasks.length);
    }
}
