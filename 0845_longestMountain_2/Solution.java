/*
LeetCode Problem No.0845:   https://leetcode-cn.com/problems/longest-mountain-in-array/
Author:                     zhangyixing1007
Idea:                       similar to Method 1 but faster
Time:                       2 ms, beat 99.84%
Space:                      39.1 MB, beat 96.46%
*/

class Solution { 
    public int longestMountain(int[] A) {
        int n = A.length;
        int ans = 0;
        int left = 0;
        while (left + 2 < n) {
            int right = left + 1;
            if (A[left] < A[left + 1]) {
                // p=1
                while (right + 1 < n && A[right] < A[right + 1]) {
                    ++right;
                }
                if (right + 1 < n  && A[right] > A[right + 1]) {
                    // p=2
                    while (right + 1 < n && A[right] > A[right + 1]) {
                        ++right;
                    }
                    ans = Math.max(ans, right - left + 1);
                } else {
                    // 只有一种情况：right + 1 < n && A[right] == A[right + 1]
                    // 跳回p=0
                    ++right;
                }
            }
            left = right;
        }
        return ans;
    }
}
