/*
LeetCode Problem No.739:    https://leetcode.com/problems/daily-temperatures/
Author:                     zhangyixing1007
Idea:                       Stack
Time:                       18 ms, beat 85.27%
Space:                      47.4 MB, beat 6.45%
*/

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] ans=new int[T.length];
        Stack stack=new Stack();
        for(int i=0; i<T.length; i++){
            while(!stack.isEmpty()&&
                 T[(Integer) stack.peek()]<T[i]){
                int t=(Integer) stack.pop();
                ans[t]=i-t;
            }
            stack.push(i);
        }
        return ans;
    }
}
