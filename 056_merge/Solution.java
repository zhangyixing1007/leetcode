/*
LeetCode Problem No.56:     https://leetcode.com/problems/merge-intervals/
Author:                     zhangyixing1007
Idea:                       first sort, then one scan
Time:                       8 ms, beat 90.08%
Space:                      43.4 MB, beat 68.97%
*/

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals==null||intervals.length==0) return new int[0][];
        List<int[]> list=new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0]-o2[0];
            }
        });
        int i=0;
        while (i<intervals.length){
            int l=intervals[i][0], r=intervals[i][1];
            i++;
            while (i<intervals.length&&intervals[i][0]<=r){
                r=Math.max(r,intervals[i][1]); i++;
            }
            list.add(new int[]{l,r});
        }
        return list.toArray(new int[0][]);
    }
}
