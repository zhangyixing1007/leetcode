/*
LeetCode Problem No.036:    https://leetcode-cn.com/problems/valid-sudoku/
Author:                     zhangyixing1007
Idea:                       HashSet, one loop (even slow than 3 loops in Version 2)
Time:                       3 ms, beat 65.27%
Space:                      39.7 MB, beat 100%
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer> [] rows = new HashSet[9];
        HashSet<Integer> [] columns = new HashSet[9];
        HashSet<Integer> [] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<Integer>();
            columns[i] = new HashSet<Integer>();
            boxes[i] = new HashSet<Integer>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int)num;
                    int box_index = (i / 3 ) * 3 + j / 3;

                    if(rows[i].contains(n) || 
                    columns[j].contains(n) || 
                    boxes[box_index].contains(n)) 
                        return false;
                    rows[i].add(n);
                    columns[j].add(n);
                    boxes[box_index].add(n);
                }
            }
        }

        return true;
    }
}
