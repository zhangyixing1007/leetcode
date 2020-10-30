/*
LeetCode Problem No.0463:   https://leetcode-cn.com/problems/island-perimeter/
Author:                     zhangyixing1007
Idea:                       dfs, recursion
Time:                       13 ms, beat 11.01%
Space:                      40.4 MB, beat 5.03%
*/

// 基本原理      
// dfs返回的是与该点连通的且未被访问过的字块的边
// 只用dfs遍历为1的字块
// 如果不幸地遍历到了为0的字块 说明找到了一个边界 返回1
class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public int islandPerimeter(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    // 以(i, j)为起点出发开始深度搜索
                    ans += dfs(i, j, grid, n, m);
                }
            }
        }
        return ans;
    }

    public int dfs(int x, int y, int[][] grid, int n, int m) {
        // 当前为0，前一步一定为1，这里就发现了一条边，所以返回1
        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 0) {
            return 1;
        }
        // 如果这个格子已经被访问过 那么我们打道回府
        if (grid[x][y] == 2) {
            return 0;
        }
        // 表示该格子已经被访问了 防止循环访问 做上记号
        grid[x][y] = 2;
        int res = 0;
        // 四个方向都探索一下
        for (int i = 0; i < 4; ++i) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            res += dfs(tx, ty, grid, n, m);
        }
        return res;
    }
}
