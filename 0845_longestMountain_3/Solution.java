/*
LeetCode Problem No.0845:   https://leetcode-cn.com/problems/longest-mountain-in-array/
Author:                     zhangyixing1007
Idea:                       dynamic programming
Time:                       3 ms, beat 69.39%
Space:                      39.1 MB, beat 97.70%
*/

class Solution { 
    public int longestMountain(int[] A) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        int[] left = new int[n];//以i为右端点的连续上升序列最长能有多长
        for (int i = 1; i < n; ++i) {
            left[i] = A[i - 1] < A[i] ? left[i - 1] + 1 : 0;
        }
        int[] right = new int[n];//以i为左端点的连续下降序列最长能有多长
        for (int i = n - 2; i >= 0; --i) {
            right[i] = A[i + 1] < A[i] ? right[i + 1] + 1 : 0;
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (left[i] > 0 && right[i] > 0) {
                // left[i] + right[i] + 1 是以i为顶峰的最长山脉长度
                ans = Math.max(ans, left[i] + right[i] + 1);
            }
        }
        return ans;
    }
}
