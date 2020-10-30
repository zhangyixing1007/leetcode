/*
LeetCode Problem No.0463:   https://leetcode-cn.com/problems/island-perimeter/
Author:                     zhangyixing1007
Idea:                       dfs, iteration
Time:                       9 ms, beat 56.99%
Space:                      39.7 MB, beat 48.90%
*/

// 利用了特性：一条周长不能同时属于两个为1的格子
class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public int islandPerimeter(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    int cnt = 0;
                    for (int k = 0; k < 4; ++k) {
                        int tx = i + dx[k];
                        int ty = j + dy[k];
                        if (tx < 0 || tx >= n || ty < 0 || ty >= m || grid[tx][ty] == 0) {
                            cnt += 1;
                        }
                    }
                    ans += cnt;
                }
            }
        }
        return ans;
    }
}
