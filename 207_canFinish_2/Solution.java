/*
LeetCode Problem No.207:    https://leetcode.com/problems/course-schedule/
Author:                     zhangyixing1007
Idea:                       topological sorting, dfs, find circle start from each vertex
Time:                       6 ms, beat 95.72%
Space:                      44.3 MB, beat 71.56%
*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashSet[] nexts=new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++){
            nexts[i] = new HashSet<Integer>();
        }        
        for (int[] pre:prerequisites){
            nexts[pre[1]].add(pre[0]);
        }
        int[] visited=new int[numCourses];
        for (int i=0; i<numCourses; i++){
            if(hasCircle(i, nexts, visited)) return false;
        }
        return true;
    }
    
    boolean hasCircle(int i, HashSet<Integer>[] nexts, int[] visited){
        if(visited[i]==-1) return true;
        if(visited[i]==1) return false;
        visited[i]=-1;
        for(int next:nexts[i]){
            if(hasCircle(next, nexts, visited))
                return true;
        }
        visited[i]=1;
        return false;
    }
}
