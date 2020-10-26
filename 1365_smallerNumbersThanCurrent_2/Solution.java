/*
LeetCode Problem No.1365:   https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
Author:                     zhangyixing1007
Idea:                       sort with index
Time:                       6 ms, beat 66.41%
Space:                      38 MB, beat 99.74%
*/

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n=nums.length;
        int[][] data=new int[n][2];
        for(int i=0; i<n; i++){
            data[i][0]=nums[i];
            data[i][1]=i;
        }
        Arrays.sort(data, (o1,o2)->o1[0]-o2[0]);
        int prev=-1;
        for(int i=0; i<n; i++){
            if(prev==-1 || data[i][0]!=data[i-1][0]){
                prev=i;
            }
            nums[data[i][1]]=prev;
        }
        return nums;
    }
}
