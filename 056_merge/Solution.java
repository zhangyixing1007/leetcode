/*
LeetCode Problem No.56:     https://leetcode.com/problems/merge-intervals/
Author:                     zhangyixing1007
Idea:                       first sort, then need only one scan
Time:                       8 ms, beat 90.08%
Space:                      43.4 MB, beat 68.97%
*/

class Solution
{
    public int[][] merge(int[][] intervals)
    {
        if (intervals==null||intervals.length==0) return new int[0][];
        List<int[]> list = new ArrayList<int[]>();
        
        Arrays.sort(intervals,new Comparator<int[]>(){
                @Override
                public int compare(int[] o1, int[] o2)
                {return o1[0]-o2[0];}
            }
        );
            
        int i = 0;
        while (i < intervals.length)
        {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while(i < intervals.length-1&&right >= intervals[i+1][0])
            {
                i++;
                right = Math.max(right,intervals[i][1]);
            }
            i++;
            list.add(new int[]{left,right});
        }
        return list.toArray(new int[0][]);
    }
}
