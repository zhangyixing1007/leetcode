  
/*
LeetCode Problem No.1207:   https://leetcode-cn.com/problems/unique-number-of-occurrences/
Author:                     zhangyixing1007
Idea:                       int[] + HashSet
Time:                       2 ms, beat 90.97%
Space:                      38.1 MB, beat 11.40%
*/

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] count=new int[2001];
        for(int a:arr){
            count[a+1000]++;
        }
        Set<Integer> time=new HashSet<Integer>();
        for(int i=0; i<2001; i++){
            if(count[i]==0) continue;
            if(time.contains(count[i])) return false;
            time.add(count[i]);
        }
        return true;
    }
}
