/*
LeetCode Problem No.207:    https://leetcode.com/problems/course-schedule/
Author:                     zhangyixing1007
Idea:                       topological sorting, based on Version 1 
Time:                       40 ms, beat 52.1%
Space:                      44.8 MB, beat 58.02%
*/

class Solution{
    public boolean canFinish(int numCourses, int[][] prerequisites){
        int[] count = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++){
            count[prerequisites[i][1]]++;
        }
        while (numCourses>1){
            numCourses --;
            int delete=-1;
            for (int i = 0; i < count.length; i++){
                if (count[i] == 0) {delete = i; break;}
            }
            if (delete == -1) return false;
            count[delete] = -1;
            for (int i = 0; i < prerequisites.length; i++){
                if (prerequisites[i][0] == delete &&
                    count[prerequisites[i][1]]>0){
                    count[prerequisites[i][1]]--;                  
                }
            }                     
        }
        return true;        
    }
}
