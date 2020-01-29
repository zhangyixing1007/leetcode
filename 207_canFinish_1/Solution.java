/*
LeetCode Problem No.207:    https://leetcode.com/problems/course-schedule/
Author:                     zhangyixing1007
Idea:                       topological sorting 
Time:                       38 ms, beat 61.13%
Space:                      44.5 MB, beat 70.61%
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
                if (prerequisites[i][0] == delete){
                    count[prerequisites[i][1]]--;
                    prerequisites[i][0] = -1;
                    prerequisites[i][1] = -1;                     
                }
            }                     
        }
        return true;        
    }
}
