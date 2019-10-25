/*
LeetCode Problem No.406:    https://leetcode.com/problems/queue-reconstruction-by-height/
Author:                     zhangyixing1007
Idea:                       sort by defined way, and insert from high to low
Time:                       51 ms, beat 44.23%
Space:                      43.4 MB, beat 92.45%
*/

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(o1,o2) -> o1[0] == o2[0]? o1[1] - o2[1] : o2[0] - o1[0] );
        
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < people.length; i++){
            list.add(people[i][1],people[i]);
        }
        
        return list.toArray(new int[list.size()][2]);
    }
}
