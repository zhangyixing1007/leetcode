/*
LeetCode Problem No.207:    https://leetcode.com/problems/course-schedule/
Author:                     zhangyixing1007
Idea:                       topological sorting, dfs, find circle start from each vertex
Time:                       6 ms, beat 95.72%
Space:                      44.3 MB, beat 71.56%
*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0||prerequisites.length==0) return true;
        HashSet[] nextVt = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++){
            nextVt[i] = new HashSet<Integer>();
        }
        for (int[] entry : prerequisites){
            nextVt[entry[1]].add(entry[0]);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++){
            if(hasCircle(i,nextVt,visited)) 
                return false;
        }
        return true;
    }
    
    boolean hasCircle(int i, HashSet<Integer>[] nextVt, int[] visited){
        if (visited[i] == -1) return true;
        if (visited[i] == 1) return false;
        visited[i] = -1;
        for (Integer next : nextVt[i]){
            if (hasCircle(next,nextVt,visited))
                return true;
        }
        visited[i] = 1;
        return false;
    }
}
